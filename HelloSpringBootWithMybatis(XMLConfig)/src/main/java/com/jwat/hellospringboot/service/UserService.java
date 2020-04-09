package com.jwat.hellospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwat.hellospringboot.entity.UserEntity;
import com.jwat.hellospringboot.mapper.UserMapper;

@Service(value = "userService")
public class UserService {
	@Autowired
    private UserMapper userMapper;
 
    public int insertUser(UserEntity user) {
        return userMapper.insertUser(user);
    }
 
    public int updateUser(UserEntity user) {
        return userMapper.updateUser(user);
    }
 
    public int deleteUserByUsername(String username) {
        return userMapper.deleteUserByUsername(username);
    }
 
    public List<UserEntity> selectAllUser() {
        return userMapper.selectAllUser();
    }
 
    public UserEntity selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
    public UserEntity selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }
}
