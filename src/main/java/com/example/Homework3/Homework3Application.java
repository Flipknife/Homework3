package com.example.Homework3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@com.example.Homework3.OpenAPIDefinition
@RestController
public class Homework3Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework3Application.class, args);

	}
    @GetMapping("/")
    public String hello() {
        return "Application is running";
    }
}
