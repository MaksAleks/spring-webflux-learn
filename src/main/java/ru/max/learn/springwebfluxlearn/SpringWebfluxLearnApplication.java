package ru.max.learn.springwebfluxlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
public class SpringWebfluxLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxLearnApplication.class, args);
    }

}
