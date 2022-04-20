package section1Dynamic;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Group {
	static int groupNumber=0;
	 int me;
	public JTextArea textArea = new JTextArea(); 
	JLabel label = new JLabel(); 
	Group(){
		me=groupNumber% 3;
		label.setText("Section "+me);
		groupNumber++;
	}
}
