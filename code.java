package chatBot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;

public class ChatBot extends JFrame implements KeyListener{

	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
	
	String[][] chatBot={
		//standard greetings
		{"hi","hello","hola sara","hi sara","sara?"},
		{"hiii -_-","hello-_-","hey!! -_-"},
		{"whats your name","why sara",},{"im Sara :),SARA is a girls name , meaning PRINCESS",},
		{"hey",},{"bolre","bola",},
		{"tell me about yourself",},{"Im an AI software that can simulate a vital conversation",},
		//question greetings
		{"how are you","how r you","how r u","how are u",},
		{"good :)","im sad :(",},
		{"what is java",},{"java is a object oriented programing language",},
		{"best gun in pubg",},{"M416",},
		{"are you real",},{"im the real deal :>,as good as they come, are you real???",},
		{"chu chu",},{"on the board next stop to the safezone",},
		{"your best dialoge",},{"sawadee kha!! happy now -_-",},
		{"how old are you",},{"age has no meaning,coz im immortal,but im created in march20 by Pushpak",},
		{"where do you live",},{"hmm,im not sure im alive :-/,",},
		{"what are your hobbies",},{"i like talking to my master",},
		{"tell me a joke"},{"wht keeps rockstars cool?? their fans :)"},{"a joke plz"},{"why cant elephants use computer,coz they r scared of mouse"},
		
		//yes
		{"yes"},
		{"no","NO","NO!!!!!!!"},
		//default
		{"sorry i didnt undestand :-/","ive no idea what you talking about :-/",
		"(Sara is unavailable, )"}
	};
	
	public static void main(String[] args){
		new ChatBot();
	}
	
	public ChatBot(){
		super("Chat Bot");
		setSize(600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
	
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(255,0,255));
		add(p);
		
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			//-----grab quote-----------
			String quote=input.getText();
			input.setText("");
			addText("-->You:\t"+quote);
			quote.trim();
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			){
				quote=quote.substring(0,quote.length()-1);
			}
			quote.trim();
			byte response=0;
			/*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
			*/
			//-----check for matches----
			int j=0;//which group we're checking
			while(response==0){
				if(inArray(quote.toLowerCase(),chatBot[j*2])){
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n*>SARA>>>>>\t"+chatBot[(j*2)+1][r]);
				}
				j++;
				if(j*2==chatBot.length-1 && response==0){
					response=1;
				}
			}
			
			//-----default--------------
			if(response==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\n*>Sara>>\t"+chatBot[chatBot.length-1][r]);
			}
			addText("\n");
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i=0;i<str.length;i++){
			if(str[i].equals(in)){
				match=true;
			}
		}
		return match;
	}
}

