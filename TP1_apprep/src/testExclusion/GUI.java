package testExclusion;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.BorderLayout;
public class GUI {
	GUI(){
		JFrame frame = new JFrame(); 
		JTextArea textArea1 = new JTextArea(); JLabel label1 = new JLabel("Section 1");
		JTextArea textArea2 = new JTextArea(); JLabel label2 = new JLabel("Section 2"); 
		JPanel panel = new JPanel(); panel.setBorder(BorderFactory.createEmptyBorder(100, 30, 10, 30)); panel.setLayout(new GridLayout(0, 1)); 
		 panel.add(label1); panel.add(textArea1);
		 panel.add(label2); panel.add(textArea2);
		frame.add(panel, BorderLayout.CENTER); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setTitle("Our GUI"); frame.pack(); 
		frame.setVisible(true); 
	}
	public static void main(String args[]){
		GUI myGUI=new GUI();
	}
}
