package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class HelloController {
    @Autowired
    private HelloService service;

    @GetMapping("/hello")
    public String getHello() {
        return "hello everyone";
    }

    @PostMapping("/hello")
    public String postRequest(@RequestParam("text1") String str) {
        return "hello/response " + str;
    }

    @PostMapping("/hello/db")
    public Employee postDbRequest(@RequestParam("text2") String id) {
        Employee employee = service.getEmployee(id);
        return employee;
    }
}
