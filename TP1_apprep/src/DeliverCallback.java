import java.io.IOException; 
import com.rabbitmq.client.Delivery;

@FunctionalInterface
public interface DeliverCallback { 
 void handle(String consumerTag, Delivery message) throws IOException;  
}