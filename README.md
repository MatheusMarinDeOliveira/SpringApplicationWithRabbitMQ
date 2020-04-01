# SpringApplicationWithRabbitMQ

### Requirements
* Oracle Database 
* RabbitMQ
* Docker


You can use images to create a docker container to run the requirements!\
Oracle: https://hub.docker.com/r/orangehrm/oracle-xe-11g\
RabbitMQ: https://hub.docker.com/_/rabbitmq

### Get Started
Follow these steps to test this project:
1. To start rabbit mq, download image on docker hub and
    ```sh
    docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 -p 5672:5672 rabbitmq:3-management
    ```
2. To initialize the rabbit mq management
    ```sh
    docker exec -it some-rabbit rabbitmq-plugins enable rabbitmq_management
    ```
3. Run the command to initialize an oracle database
    ```sh
    docker run -d --shm-size=2g -p 1521:1521 -p 8081:8081 orangehrm/oracle-xe-11g
    ```
4. Start the application using
    ```sh
    ./gradlew bootRun
    ```
Now you can send requests and test the program!

Requests example:
POST http://localhost:9090/user
Body {"idUser": 1, "name": "name", "password":"password"}
