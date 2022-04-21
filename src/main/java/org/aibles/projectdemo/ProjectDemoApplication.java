package org.aibles.projectdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(value = {"org.aibles.projectdemo.repository"})
@SpringBootApplication
public class ProjectDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectDemoApplication.class, args);
    }

}
