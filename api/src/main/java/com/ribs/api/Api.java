package com.ribs.api;

import com.ribs.api.rest.connection.DBConnect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Api {

    public static void main(String[] args) {
        System.out.println("Hello from API service");
        KafkaConnectionHelper kafkaConnectionHelper = new KafkaConnectionHelper();
        KafkaConnectionHelper.setKafkaConnectionHelper(kafkaConnectionHelper);
        kafkaConnectionHelper.consume();
        DBConnect.makeJDBCConnection();
        SpringApplication.run(Api.class, args);
    }
}
