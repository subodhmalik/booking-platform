package com.bmp.metadata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MetaDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaDataApplication.class, args);
        System.out.println("✅ Meta Data Application  is up and running!");
    }
}