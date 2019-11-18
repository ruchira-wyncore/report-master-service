package com.wyncore.mysql.rest.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This is a spring configuration class to enable
 * CORS mapping to the localhost URL at port 4200.
 * This is to make sure that the application accepts the call from
 * the front end.
 */
@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    /**
     * This maps the front end url to the mapping tabble so that http connection to it
     * can get accepted.
     * @param registry :- cors registry where mapping is added.,
     */
    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200");
    }
}
