package com.example.demo.controller;

import com.example.demo.service.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class SignupController {
    @Autowired
    private UserApplicationService userApplicationService;

    @GetMapping("/signup")
    public Map<String, Integer> getSignup() {
        return userApplicationService.getGenderMap();
    }

    @PostMapping("/signup")
    public String postSignup() {
        return "redirect:/login";
    }
}
