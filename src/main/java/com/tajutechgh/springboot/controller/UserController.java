package com.tajutechgh.springboot.controller;

import com.tajutechgh.springboot.dto.UserDto;
import com.tajutechgh.springboot.entity.User;
import com.tajutechgh.springboot.exception.ErrorDetails;
import com.tajutechgh.springboot.exception.ResourceNotFoundException;
import com.tajutechgh.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "CRUD REST APIs", description = "CRUD REST APIs for User")
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create a new user", description = "Create a new user REST API")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {

        UserDto savedUser = userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a user by ID", description = "Get a user by ID REST API")
    @ApiResponse(responseCode = "200", description = "User found successfully")
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserBYId(@PathVariable Long userId) {

        UserDto user = userService.getUserBYId(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Get all users", description = "Get all users REST API")
    @ApiResponse(responseCode = "200", description = "Users found successfully")
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Update a user", description = "Update a user REST API")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user, @PathVariable Long userId) {

        user.setId(userId);

        UserDto updatedUser = userService.updateUser(user);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(summary = "Delete a user", description = "Delete a user REST API")
    @ApiResponse(responseCode = "200", description = "User deleted successfully")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {

        userService.deleteUser(userId);

        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
//
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}