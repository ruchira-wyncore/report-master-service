package com.wyncore.mysql.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/**
 * This is a springboot application  which acts as restful end point for  handling mysql api calls.
 */
@ComponentScan(basePackages = { "com.wyncore.mysql.rest.api" })
@EntityScan("com.wyncore.mysql.rest.api.model")
@EnableJpaRepositories("com.wyncore.mysql.rest.api.repository")
public class RestfulSqlCallsController {
    public static void main(String[] args) {
        SpringApplication.run(RestfulSqlCallsController.class, args);
    }
}
