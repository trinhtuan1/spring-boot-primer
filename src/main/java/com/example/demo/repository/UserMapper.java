package com.example.demo.repository;

import com.example.demo.domain.user.model.MUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int insertOne(MUser user);

    public List<MUser> findMany();
}
