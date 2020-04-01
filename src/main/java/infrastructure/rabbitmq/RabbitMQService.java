package infrastructure.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.UserVO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RabbitMQService {

    private final String EXCHANGE_NAME = "EXCHANGE_NAME";
    private final String ROUTING_KEY = "foo.bar.#";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageToRabbit(Integer idUser, String name, String password) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserVO userVO = new UserVO(idUser, name, password);
        try {
            String message = objectMapper.writeValueAsString(userVO);
            byte[] bytes = message.getBytes();
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, bytes);
        } catch (JsonProcessingException e) {
            System.out.println("Cannot send to rabbit");
        }
    }
}
