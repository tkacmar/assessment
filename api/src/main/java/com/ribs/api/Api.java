package com.ribs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Api {

    public static void main(String[] args) {
        System.out.println("Hello from API service");
        SpringApplication.run(Api.class, args);


    }

}
