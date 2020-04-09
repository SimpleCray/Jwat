package com.jwat.hellospringboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jwat.hellospringboot.entity.UserEntity;

@Mapper
public interface UserMapper {
	public int insertUser(UserEntity user);
    public int updateUser(UserEntity user);
    public int deleteUserByUsername(String username);
    public List<UserEntity> selectAllUser();
    public UserEntity selectUserByUsername(String username);
    public UserEntity selectUserByEmail(String email);
}
	