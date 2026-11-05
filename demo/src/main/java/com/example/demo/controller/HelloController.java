package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! My first Spring Boot API";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is my first Spring Boot project.";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/api/users")
    public List<Map<String, Object>> getUsers() {
        return List.of(
            Map.of("id", 1, "name", "Ahmad", "email", "ahmad@gmail.com"),
            Map.of("id", 2, "name", "Sara", "email", "sara@gmail.com"),
            Map.of("id", 3, "name", "Omar", "email", "omar@gmail.com")
        );
    }
}