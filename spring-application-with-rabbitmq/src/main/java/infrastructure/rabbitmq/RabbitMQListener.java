package infrastructure.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.UserVO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import infrastructure.oracledb.OracleService;

@Component
public class RabbitMQListener {

    @Autowired
    public OracleService oracleService;

    @RabbitListener(queues = "QUEUE_NAME")
    public void listen(byte[] message) {
        ObjectMapper objectMapper = new ObjectMapper();
        String messageInJson = new String(message);
        try {
            UserVO userVO = objectMapper.readValue(messageInJson, UserVO.class);
            oracleService.createUserInDatabase(userVO);

        } catch (Exception e) {
            System.out.println("Cannot deserialize the fields");
        }
        System.out.println("I listened a message from RabbitMQ!!");
    }
}
