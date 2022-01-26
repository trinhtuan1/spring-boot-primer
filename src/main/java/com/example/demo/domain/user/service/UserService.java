package com.example.demo.domain.user.service;


import com.example.demo.domain.user.model.MUser;

import java.util.List;

public interface UserService {
    public void signup(MUser user);

    public List<MUser> getUsers(MUser user);

    public MUser getOneUser(String userId);

    public String updateOneUser(String userId, String password, String userName);

    public String deleteOneUser(String userId);

    public MUser getLoginUser(String userId);
}
