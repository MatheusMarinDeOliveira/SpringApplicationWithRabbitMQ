package controller;

import infrastructure.rabbitmq.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"infrastructure.rabbitmq"})
public class SpringController {

    @Autowired
    public RabbitMQService rabbitMQService;

    @GetMapping("/saveUser")
    public String greeting(@RequestParam("idUser") Integer idUser, @RequestParam("name") String name, @RequestParam("password") String password) {
        rabbitMQService.sendMessageToRabbit(idUser, name, password);
        return "user created in database!!";
    }
}
