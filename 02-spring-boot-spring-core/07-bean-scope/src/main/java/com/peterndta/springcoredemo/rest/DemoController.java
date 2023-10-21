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
    private Coach anotherCoach;

    // define a constructor for dependency injection with Qualifier
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDaiyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check") // nếu singleton thì true, nếu class cricketCoach có scope là prototype thì false
    public String check() {
        return "comparing beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
    }
}
