package com.sparta.spring_basic_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBasicAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicAssignmentApplication.class, args);
    }
}