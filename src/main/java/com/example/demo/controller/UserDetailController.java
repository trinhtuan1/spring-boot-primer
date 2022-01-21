package com.example.demo.controller;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserDetailForm;
import org.apache.ibatis.annotations.Param;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/detail", params = "update")
    public String updateOneUser(@ModelAttribute UserDetailForm form) {
        userService.updateOneUser(form.getUserId(), form.getPassword(), form.getUserName());
        return "success";
    }

    @PostMapping(value = "/detail", params = "delete")
    public String deleteOneUser(@Param("userId") String userId) {
        return userService.deleteOneUser(userId);
    }
}
