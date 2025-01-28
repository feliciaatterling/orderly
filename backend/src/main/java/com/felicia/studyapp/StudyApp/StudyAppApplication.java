package com.felicia.studyapp.StudyApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.felicia.studyapp")  // Ensures all components are scanned
@EnableJpaRepositories(basePackages = "com.felicia.studyapp.repositories")  // Ensures JPA Repositories are scanned
@EntityScan(basePackages = "com.felicia.studyapp.models")  // Ensures Entities are scanned
public class StudyAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyAppApplication.class, args);
    }
}
