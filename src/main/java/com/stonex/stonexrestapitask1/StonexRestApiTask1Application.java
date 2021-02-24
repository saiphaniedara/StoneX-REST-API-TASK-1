package com.stonex.stonexrestapitask1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.stonex")
@EnableMongoRepositories(basePackages = "com.stonex")
public class StonexRestApiTask1Application {

    public static void main(String[] args) {
        SpringApplication.run(StonexRestApiTask1Application.class, args);
    }

}
