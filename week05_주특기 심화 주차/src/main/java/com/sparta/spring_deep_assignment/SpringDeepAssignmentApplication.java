package com.sparta.spring_deep_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDeepAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDeepAssignmentApplication.class, args);
    }

}
