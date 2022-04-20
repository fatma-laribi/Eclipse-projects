package section1Dynamic;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.CaretListener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


//disable sections lo5rin
//sender receiver
public class User extends javax.swing.JFrame {
	 static int userNumber=0;
	 int me;
	 static int nbSections;
	JFrame frame;
	static ArrayList<User> allUsers=new ArrayList<User>();
	Group[] allSections;
	static String queues[];
	User(){
		allSections = new Group[nbSections];
		queues=new String[nbSections];
		for(int i=0;i<nbSections;i++) {
			queues[i]="mq"+(i+1);
    		allSections[i]=new Group();
    		addListener(i,allSections[i].textArea);}
		
		me=userNumber;
	    userNumber++;
		frame = new JFrame(); 
		JPanel panel = new JPanel(); 
		panel.setBorder(BorderFactory.createEmptyBorder(100, 30, 10, 30)); 
		panel.setLayout(new GridLayout(0, 1)); 
		for(int i=0;i<allSections.length;i++) {
			panel.add(allSections[i].label); 
			if (i!= me) allSections[i].textArea.setEnabled(false);
			panel.add(allSections[i].textArea);
		}
		frame.add(panel, BorderLayout.CENTER); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setTitle("User "+me); frame.setSize(500, 300);
		frame.setVisible(true);
		allUsers.add(this);
		
	}
	void addListener(int i,JTextArea textArea) {
		textArea.addCaretListener(new CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent e) {
            	System.out.println(" entered handler");
            	ConnectionFactory factory = new ConnectionFactory(); factory.setHost("localhost"); 
            	try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) 
            	{ channel.queueDeclare(queues[i], false, false, false, null); 
            	String message = allSections[i].textArea.getText(); 
            	channel.basicPublish("", queues[i], null, message.getBytes()); 
            	System.out.println(" [x] Sent '" + message + "'"); 
            } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TimeoutException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            	}});
	}
	}

	
