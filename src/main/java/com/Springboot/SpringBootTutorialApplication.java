package com.Springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.Springboot")
public class SpringBootTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
        System.out.println("SpringBoot application started");
    }

}
