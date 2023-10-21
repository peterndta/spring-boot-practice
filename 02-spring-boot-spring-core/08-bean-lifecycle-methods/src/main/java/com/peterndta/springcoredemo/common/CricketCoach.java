package com.peterndta.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // Define init method
    @PostConstruct
    public void doStartUpStuff(){
        System.out.println("Startup Setup!!: " + getClass().getSimpleName());
    }

    // Define destroy method
    @PreDestroy
    public void doDestroyStuff(){
        System.out.println("Destroy Setup!!: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice bowling 123";
    }


}
