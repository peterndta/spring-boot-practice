package com.peterndta.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need controller method to show form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // controller to process HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // controller to read form data and add to model
    @RequestMapping("/processFormVersionTwo")
    public String shout(HttpServletRequest request, Model model){

        // read request params từ HTML form
        String theName = request.getParameter("studentName");
        // convert data to uppsercase
        theName = theName.toUpperCase();
        // create message
        String result = "Yo" + theName;
        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        // convert data to uppsercase
        theName = theName.toUpperCase();
        // create message
        String result = "Hey: " + theName;
        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
