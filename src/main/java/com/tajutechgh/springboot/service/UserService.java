package com.tajutechgh.springboot.service;

import com.tajutechgh.springboot.dto.UserDto;
import com.tajutechgh.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserBYId(Long id);

    List<UserDto> getAllUsers(); // List<User>

    UserDto updateUser(UserDto user);

    void deleteUser(Long id);
}
