package controller;

import entities.UserVO;
import infrastructure.rabbitmq.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"infrastructure.rabbitmq"})
public class SpringController {

    @Autowired
    public RabbitMQService rabbitMQService;

    @PostMapping("/user")
    public String saveUser(@RequestBody UserVO payload) {
        rabbitMQService.sendMessageToRabbit(payload.getIdUser(), payload.getName(), payload.getPassword());
        return "user " + payload.getName() + " created in database!!";
    }
}
