package com.nokhacode.userapp.controller;

import com.nokhacode.userapp.dto.*;
import com.nokhacode.userapp.entity.UserEntity;
import com.nokhacode.userapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * create new user
     *
     * @param createUserDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> createUser(@RequestBody CreateUserDTO createUserDTO) {
        log.info("creat new user.....");
        UserEntity newUser = userService.createUser(createUserDTO);
        Response response = Response.builder().data(newUser).build();
        return ResponseEntity.ok(response);
    }

    /**
     * Get all the users
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<Response> getAllUsers() {
        log.info("get all user.....");

        List<UserDTO> allUsers = userService.getAllUsers();
        Response response = Response.builder().data(allUsers).build();
        return ResponseEntity.ok(response);
    }

    /**
     * get user by userId
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ResponseEntity<Response> getUserById(@PathVariable("userId") Long userId) {
        log.info("get user by id.....");

        UserDTO userById = userService.getUserById(userId);
        Response response = Response.builder().data(userById).build();
        return ResponseEntity.ok(response);
    }

    /**
     * update user info by userId
     *
     * @param updateUserDTO
     * @return
     */
    @PutMapping
    public ResponseEntity<Response> updateUserById(@RequestBody UpdateUserDTO updateUserDTO) {
        log.info("update user by id.....");

        UserDTO updatedUser = userService.updateUser(updateUserDTO);
        Response response = Response.builder().data(updatedUser).build();
        return ResponseEntity.ok(response);
    }

    /**
     * update user password by user id
     *
     * @param updateUserPasswordDTO
     * @return
     */
    @PutMapping("/password")
    public ResponseEntity<Response> updateUserPasswordById(@RequestBody UpdateUserPasswordDTO updateUserPasswordDTO) {
        UserDTO updatedUser = userService.resetUserPasswordById(updateUserPasswordDTO.getId(), updateUserPasswordDTO);
        Response response = Response.builder().data(updatedUser).build();
        return ResponseEntity.ok(response);
    }

    /**
     * delete user by userId
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Response> deleteUserById(@PathVariable("userId") Long userId) {
        log.info("delete user by id.....");
        userService.deleteUserById(userId);
        return ResponseEntity.ok(Response.builder().data("User deleted successfully").build());
    }
}
