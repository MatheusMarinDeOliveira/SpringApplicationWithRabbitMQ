package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.oracledb.OracleService;
import services.rabbitmq.RabbitMQService;

@RestController
@ComponentScan(basePackages = {"services.rabbitmq"})
public class SpringController {

    @Autowired
    public RabbitMQService rabbitMQService;

    @Autowired
    public OracleService oracleService;

    @GetMapping("/saveUser")
    public String greeting(@RequestParam("idUser") String idUser, @RequestParam("name") String name, @RequestParam("password") String password) {

        rabbitMQService.sendMessageToRabbit(idUser, name, password);
        return "ok";
    }

    @GetMapping("/connectInDatabase")
    public String greeting() {
        oracleService.connectInDatabase();
        return "connected in database!";
    }

}
