package com.bmp.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieAndShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieAndShowApplication.class, args);
        System.out.println("✅ Movie and Show Application  is up and running!");
    }
}