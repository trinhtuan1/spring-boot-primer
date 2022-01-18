package com.example.demo.controller;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserDetailForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserDetailController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/detail/{userId:.+}")
    public UserDetailForm getUserDetail(@PathVariable("userId") String userId) {
        UserDetailForm form;
        MUser user = userService.getOneUser(userId);
        user.setPassword(null);
        form = modelMapper.map(user, UserDetailForm.class);
        return form;
    }
}
