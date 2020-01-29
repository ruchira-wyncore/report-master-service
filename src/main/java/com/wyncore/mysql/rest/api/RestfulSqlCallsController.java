package com.wyncore.mysql.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is a Spring-Boot application  which acts as restful end point for  handling MYSQL api
 * calls.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wyncore.mysql.rest.api"})
@EntityScan("com.wyncore.mysql.rest.api.model")
@EnableJpaRepositories("com.wyncore.mysql.rest.api.repository")
public class RestfulSqlCallsController {

  /**
   * Main method.
   *
   * @param args :- arguments passed when application comes up.
   */
  public static void main(final String[] args) {
    SpringApplication.run(RestfulSqlCallsController.class, args);
  }
}
