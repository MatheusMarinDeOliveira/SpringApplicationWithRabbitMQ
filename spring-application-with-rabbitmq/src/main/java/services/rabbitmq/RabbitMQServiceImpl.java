package services.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RabbitMQServiceImpl implements RabbitMQService {


    private final String QUEUE_NAME = "QUEUE_NAME";
    private final String EXCHANGE_NAME = "EXCHANGE_NAME";
    private final String ROUTING_KEY = "foo.bar.#";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageToRabbit(byte[]  message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);

    }

}
