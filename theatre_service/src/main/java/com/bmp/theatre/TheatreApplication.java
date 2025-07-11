package com.bmp.theatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheatreApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheatreApplication.class, args);
        System.out.println("✅ Theatre Application is up and running!");
    }
}
