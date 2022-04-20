package section1Dynamic;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

public class Receiver extends javax.swing.JFrame{
static int nbSections;
static Group[] allSections;
static String queues[];
JFrame frame;
JPanel panel; 

	Receiver(int nbSections){
		Receiver.nbSections=nbSections;
		allSections=new Group[nbSections];
		queues=User.queues;
		for(int i=0;i<nbSections;i++) {
    		allSections[i]=new Group(i);
    	}
		frame = new JFrame(); 
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 30, 10, 30)); 
		panel.setLayout(new GridLayout(0, 1)); 
		for(int i=0;i<allSections.length;i++) {
			allSections[i].textArea.setEnabled(false);
			panel.add(allSections[i].label); 
			panel.add(allSections[i].textArea);
		}
		frame.add(panel, BorderLayout.CENTER); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setTitle("User "+nbSections); frame.setSize(500, 300);
		frame.setVisible(true);
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = null;
		try {
			connection = factory.newConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Channel channel = null;
			try {
				channel = connection.createChannel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(int i=0;i<nbSections;i++) {
			 try {
					channel.queueDeclare(queues[i], false, false, false, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("[*] Waiting for messages. To exit press ctrl+c");
			    final int var=i;
			    DeliverCallback deliverCallback = (consumerTag, delivery)->{
			        String message = new String(delivery.getBody(), "UTF-8");
			        allSections[var].textArea.setText(message);
			        System.out.println("[X] received '"+message +"'" );
			    };   
			   
			    try {
					channel.basicConsume(queues[i],true, deliverCallback, consumerTag ->{});
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			    
			
		}
	    
	   
}

	
}


