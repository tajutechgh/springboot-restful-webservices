package com.tajutechgh.springboot.mapper;

import com.tajutechgh.springboot.dto.UserDto;
import com.tajutechgh.springboot.entity.User;

public class UserMapper {

    // Convert User JPA Entity into UserDto
    public static UserDto mapToUserDto(User user){

        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

        return userDto;
    }

    // Convert UserDto into User JPA Entity
    public static User mapToUser(UserDto userDto){

        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );

        return user;
    }
}