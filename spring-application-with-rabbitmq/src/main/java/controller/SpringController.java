package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.RabbitMQService;

@RestController
@ComponentScan(basePackages = {"services"})
public class SpringController {

    @Autowired
    public RabbitMQService rabbitMQService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam("name") String name) {
        byte[] message = name.getBytes();
        rabbitMQService.sendMessageToRabbit(message);

        return "ok";
    }
}
