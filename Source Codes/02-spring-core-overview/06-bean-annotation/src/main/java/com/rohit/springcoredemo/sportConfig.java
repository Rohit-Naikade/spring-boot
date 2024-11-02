package com.rohit.springcoredemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class sportConfig {

    @Bean
    public Coach createCoach(){
        return new swimCoach();
    }
}
