package com.example.demo.domain.user.service.impl;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public void signup(MUser user) {
        user.setDepartmentId(1);
        user.setRole("ROLE_REGULAR");
        mapper.insertOne(user);
    }

    @Override
    public List<MUser> getUsers(MUser user) {
        return mapper.findMany(user);
    }

    @Override
    public MUser getOneUser(String userId) {
        return mapper.findOne(userId);
    }

    @Transactional
    @Override
    public String updateOneUser(String userId, String password, String userName) {
        mapper.updateOne(userId, password, userName);
        int i = 1 / 0;
        return "success";
    }

    @Override
    public String deleteOneUser(String userId) {
        int count = mapper.deleteOne(userId);
        return Integer.toString(count);
    }
}
