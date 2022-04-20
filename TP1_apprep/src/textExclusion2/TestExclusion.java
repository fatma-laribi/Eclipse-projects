package textExclusion2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class TestExclusion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	int n=Integer.parseInt(args[0]);
            	  for(int i=1; i<= n;i++) {
                     new Programme().setVisible(true);
              }

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
      	        try {
      	    		channel.queueDeclare("mq1", false, false, false, null);
      	    	} catch (IOException e) {
      	    		// TODO Auto-generated catch block
      	    		e.printStackTrace();
      	    	}
      	        
      	      Channel channel2 = null;
    	    	try {
    	    		channel2 = connection.createChannel();
    	    	} catch (IOException e) {
    	    		// TODO Auto-generated catch block
    	    		e.printStackTrace();
    	    	}
    	        try {
    	    		channel2.queueDeclare("mq2", false, false, false, null);
    	    	} catch (IOException e) {
    	    		// TODO Auto-generated catch block
    	    		e.printStackTrace();
    	    	}
    	        
    	        Channel channel3 = null;
    	    	try {
    	    		channel3 = connection.createChannel();
    	    	} catch (IOException e) {
    	    		// TODO Auto-generated catch block
    	    		e.printStackTrace();
    	    	}
    	        try {
    	    		channel3.queueDeclare("mq3", false, false, false, null);
    	    	} catch (IOException e) {
    	    		// TODO Auto-generated catch block
    	    		e.printStackTrace();
    	    	}
      	        System.out.println("[*] Waiting for messages. To exit press ctrl+c");
      	        DeliverCallback deliverCallback = (consumerTag, delivery)->{
      	            String message = new String(delivery.getBody(), "UTF-8");
      	            for(int i=0; i< Programme.allFrames.size();i++) {
      	            	if(Programme.currentWriters[0] ==-1)
      	            		Programme.allFrames.get(i).jLabel3.setText("No one is writing");
      	            	else
      	            		Programme.allFrames.get(i).jLabel3.setText("User "+ Programme.currentWriters[0] +" is writing");
      	            	
      	            	if(i != Programme.currentWriters[0] && Programme.currentWriters[0]!=-1) Programme.allFrames.get(i).jTextArea1.setText(message);
      	            }
      	            
      	        };
      	        
      	      DeliverCallback deliverCallback2 = (consumerTag, delivery)->{
      	    	String message2 = new String(delivery.getBody(), "UTF-8");
  	            for(int i=0; i< Programme.allFrames.size();i++) {
  	            	if(Programme.currentWriters[1] ==-1)
  	            		Programme.allFrames.get(i).jLabel5.setText("No one is writing");
  	            	else
  	            		Programme.allFrames.get(i).jLabel5.setText("User "+ Programme.currentWriters[1] +" is writing");
  	            	if(i != Programme.currentWriters[1] && Programme.currentWriters[1]!=-1) Programme.allFrames.get(i).jTextArea2.setText(message2);
  	            }
      	      };
      	      
      	    DeliverCallback deliverCallback3 = (consumerTag, delivery)->{
      	    	String message3 = new String(delivery.getBody(), "UTF-8");
  	            for(int i=0; i< Programme.allFrames.size();i++) {

  	            	if(Programme.currentWriters[2] ==-1)
  	            		Programme.allFrames.get(i).jLabel7.setText("No one is writing");
  	            	else
  	            		Programme.allFrames.get(i).jLabel7.setText("User "+ Programme.currentWriters[2] +" is writing");
  	            	if(i != Programme.currentWriters[2] && Programme.currentWriters[2]!=-1) Programme.allFrames.get(i).jTextArea3.setText(message3);
  	            	
  	            }
      	      };
      	        
      	        try {
      for(int i=0; i<Programme.allFrames.size();i++) {
    		if(i != Programme.currentWriters[0])   		
    			channel.basicConsume("mq1",true, deliverCallback, consumerTag ->{});
    		if(i != Programme.currentWriters[1])   		
    			channel2.basicConsume("mq2",true, deliverCallback2, consumerTag ->{});
    		if(i != Programme.currentWriters[2])   		
    			channel3.basicConsume("mq3",true, deliverCallback3, consumerTag ->{});
                  	}
      
      	    
      	    	} catch (IOException e) {
      	    		// TODO Auto-generated catch block
      	    		e.printStackTrace();
      	    	}

            }}
        );
	}

}
