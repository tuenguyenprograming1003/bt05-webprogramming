package com.example.bai5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.bai5", "com.example.demo"})
public class Bai5Application {

    public static void main(String[] args) {
        SpringApplication.run(Bai5Application.class, args);
    }

}
