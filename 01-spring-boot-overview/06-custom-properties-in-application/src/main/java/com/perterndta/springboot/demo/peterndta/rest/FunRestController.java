package com.perterndta.springboot.demo.peterndta.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoints for team Info
    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "coach: " + coachName + " - " + "team: " + teamName;
    }

//     expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard ";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day";
    }
}
