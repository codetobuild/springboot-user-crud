package com.nokhacode.userapp.service.imp;

import com.nokhacode.userapp.dto.CreateUserDTO;
import com.nokhacode.userapp.dto.UpdateUserDTO;
import com.nokhacode.userapp.dto.UpdateUserPasswordDTO;
import com.nokhacode.userapp.dto.UserDTO;
import com.nokhacode.userapp.entity.UserEntity;
import com.nokhacode.userapp.exception.BadRequest;
import com.nokhacode.userapp.exception.NotFoundException;
import com.nokhacode.userapp.mapper.UserMapper;
import com.nokhacode.userapp.repository.UserRepository;
import com.nokhacode.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(CreateUserDTO createUserDTO) {
        UserEntity user = new UserEntity();
        user.setEmail(createUserDTO.getEmail());
        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setPassword(createUserDTO.getPassword());
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(user -> {
            UserDTO userDTO = UserMapper.convertUserEntityToUserDTO(user);
            userDTOList.add(userDTO);

        });

        return userDTOList;
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()) {
            throw new NotFoundException(String.valueOf(HttpStatus.NOT_FOUND.value()), "User not found with userId: " + id);
        }
        UserEntity userEntity = foundUser.get();
        return UserMapper.convertUserEntityToUserDTO(userEntity);
    }

    @Override
    public UserDTO updateUser(UpdateUserDTO updateUserDTO) {
        UserEntity user = userRepository.findById(updateUserDTO.getId())
                .orElseThrow(() -> new NotFoundException(String.valueOf(HttpStatus.NOT_FOUND.value()), "User not found to update"));
        user.setEmail(updateUserDTO.getEmail());
        user.setFirstName(updateUserDTO.getFirstName());
        user.setLastName(updateUserDTO.getLastName());
        UserEntity updatedUser = userRepository.save(user);
        return UserMapper.convertUserEntityToUserDTO(updatedUser);
    }


    @Override
    public UserDTO resetUserPasswordById(Long id, UpdateUserPasswordDTO updateUserPasswordDTO) {
        UserEntity user = userRepository.findById(updateUserPasswordDTO.getId())
                .orElseThrow(() -> new NotFoundException(String.valueOf(HttpStatus.NOT_FOUND.value()), "User not found to update"));
        String dbOldPassword = user.getPassword();
        if (!dbOldPassword.equals(updateUserPasswordDTO.getOldPassword())) {
            throw new BadRequest(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Old password doesn't match");
        }

        user.setPassword(updateUserPasswordDTO.getNewPassword());
        UserEntity updatedUser = userRepository.save(user);
        return UserMapper.convertUserEntityToUserDTO(updatedUser);
    }


    @Override
    public void deleteUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(HttpStatus.NOT_FOUND.value()), "User not found to delete"));
        userRepository.deleteById(user.getId());
    }
}
