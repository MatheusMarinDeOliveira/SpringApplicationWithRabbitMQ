package services.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.oracledb.OracleService;

@Component
public class RabbitMQListener {

    @Autowired
    public OracleService oracleService;

    @RabbitListener(queues = "QUEUE_NAME")
    public void listen(byte[] message) {
        String messageInString = new String(message);
        oracleService.createUserInDatabase(messageInString);
        System.out.println(messageInString);
    }
}
