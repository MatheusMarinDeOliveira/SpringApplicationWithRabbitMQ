package services;

public interface RabbitMQService {

    void sendMessageToRabbit(byte[]  message);
}
