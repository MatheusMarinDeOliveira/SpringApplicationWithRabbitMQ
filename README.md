# SpringApplicationWithRabbitMQ

To start rabbit mq, download image on docker hub and

docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 rabbitmq:3-management

To initialize the rabbit mq management

rabbitmq-plugins enable rabbitmq_management
