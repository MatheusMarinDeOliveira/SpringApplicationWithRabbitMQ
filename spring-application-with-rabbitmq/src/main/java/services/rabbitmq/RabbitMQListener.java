package services.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "QUEUE_NAME")
    public void listen(byte[] message) {
        String messageInString = new String(message);
        System.out.println(messageInString);
    }
}
