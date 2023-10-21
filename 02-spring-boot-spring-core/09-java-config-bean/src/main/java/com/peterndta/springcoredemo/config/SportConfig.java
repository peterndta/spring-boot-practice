package com.peterndta.springcoredemo.config;

import com.peterndta.springcoredemo.common.Coach;
import com.peterndta.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){ // Bean ID default là swimCoach
        return new SwimCoach();
    }

}
