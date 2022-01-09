package com.example.demo.controller;

import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;
import com.example.demo.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class SignupController {
    @Autowired
    private UserApplicationService userApplicationService;

    @GetMapping("/signup")
    public Map<String, Integer> getSignup(@ModelAttribute SignupForm form) {
        return userApplicationService.getGenderMap();
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute @Validated(GroupOrder.class) SignupForm form) {
        return form.toString();
    }
}
