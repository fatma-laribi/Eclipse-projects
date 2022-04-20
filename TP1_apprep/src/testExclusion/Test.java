package testExclusion;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Test {

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
      	        System.out.println("[*] Waiting for messages. To exit press ctrl+c");
      	        DeliverCallback deliverCallback = (consumerTag, delivery)->{
      	            String message = new String(delivery.getBody(), "UTF-8");
      	            for(int i=0; i< Programme.allFrames.size();i++) {
      	            	if(Programme.currentWriter ==-1)
      	            		Programme.allFrames.get(i).jLabel5.setText("No one is writing");
      	            	else
      	            		Programme.allFrames.get(i).jLabel5.setText("User "+ Programme.currentWriter +" is writing");
      	            	if(i != Programme.currentWriter) Programme.allFrames.get(i).jTextArea1.setText(message);
      	            }
      	            System.out.println("[X] received '"+message +"'" );
      	        };
      	        try {
      for(int i=0; i<Programme.allFrames.size();i++) {
    		if(i != Programme.currentWriter)   		
      	channel.basicConsume("mq1",true, deliverCallback, consumerTag ->{});
                  	}
      	    
      	    	} catch (IOException e) {
      	    		// TODO Auto-generated catch block
      	    		e.printStackTrace();
      	    	}

            }}
        );
	}

}
