package com.sparta.spring_core_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class SpringCoreAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreAssignmentApplication.class, args);
    }

}
