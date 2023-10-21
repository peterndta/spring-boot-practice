package com.peterndta.springcoredemo.rest;

import com.peterndta.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define private field for dependency
    private Coach myCoach;

    // define a constructor for dependency injection with Qualifier
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) { // không bị ràng buộc bởi tên func
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDaiyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
