package section1Dynamic;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Group {

	public JTextArea textArea = new JTextArea(); 
	JLabel label = new JLabel(); 
	Group(int n){
	
		label.setText("Section "+n);

	}
}
