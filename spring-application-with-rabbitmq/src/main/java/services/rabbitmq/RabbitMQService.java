package services.rabbitmq;

public interface RabbitMQService {

    void sendMessageToRabbit(byte[]  message);
}
