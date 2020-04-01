package infrastructure.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.UserVO;
import infrastructure.database.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @Autowired
    public UserRepository userRepository;

    @RabbitListener(queues = "QUEUE_NAME")
    public void listen(byte[] message) {
        ObjectMapper objectMapper = new ObjectMapper();
        String messageInJson = new String(message);
        try {
            UserVO userVO = objectMapper.readValue(messageInJson, UserVO.class);
            userRepository.save(userVO);
        } catch (Exception e) {
            System.out.println("Cannot deserialize the fields");
        }
        System.out.println("I listened a message from RabbitMQ!!");
    }
}
