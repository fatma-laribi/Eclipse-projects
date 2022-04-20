package testExclusion;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender1 {
public Sender1(String message, int user) {
	ConnectionFactory factory = new ConnectionFactory(); factory.setHost("localhost"); 
	try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) 
	{ channel.queueDeclare("queue", false, false, false, null); 
	System.out.println(message);
	for(int i=0; i<Programme.allFrames.size();i++) {
		if(i != user)
		channel.basicPublish("", "mq1", null, message.getBytes());
		//if(i!= user) Programme.allFrames.get(i).jTextArea1.disable();
	}
	 
	System.out.println(" [x] User "+user); 
	System.out.println(" [x] Sent '" + message + "'"); 
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (TimeoutException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
	
	}
}

