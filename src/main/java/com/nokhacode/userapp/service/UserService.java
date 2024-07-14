package com.nokhacode.userapp.service;

import com.nokhacode.userapp.dto.CreateUserDTO;
import com.nokhacode.userapp.dto.UpdateUserDTO;
import com.nokhacode.userapp.dto.UpdateUserPasswordDTO;
import com.nokhacode.userapp.dto.UserDTO;
import com.nokhacode.userapp.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity createUser(CreateUserDTO createUserDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(UpdateUserDTO updateUserDTO);
    void deleteUserById(Long id);
    UserDTO resetUserPasswordById(Long id, UpdateUserPasswordDTO updateUserPasswordDTO);

}
