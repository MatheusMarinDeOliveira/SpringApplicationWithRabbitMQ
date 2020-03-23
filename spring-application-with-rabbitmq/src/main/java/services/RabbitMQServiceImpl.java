package services;

import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements RabbitMQService {

    public String sendMessageToRabbit() {
        return "Im sending message to Rabbit, please wait";
    }

}
