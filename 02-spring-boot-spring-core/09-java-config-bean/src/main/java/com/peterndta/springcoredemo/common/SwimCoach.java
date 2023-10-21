package com.peterndta.springcoredemo.common;

import org.springframework.context.annotation.Bean;

// Không có @Component vì dùng @Bean
public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim Coach bơi deeee";
    }
}
