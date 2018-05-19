package com.abner.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.abner")

public class Starter {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter.class,args);
    }

}
