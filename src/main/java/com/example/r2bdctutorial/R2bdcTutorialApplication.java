package com.example.r2bdctutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class R2bdcTutorialApplication {
    public static void main(String[] args) {
        SpringApplication.run(R2bdcTutorialApplication.class, args);
    }
}
