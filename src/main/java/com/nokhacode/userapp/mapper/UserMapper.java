package com.nokhacode.userapp.mapper;


import com.nokhacode.userapp.dto.UserDTO;
import com.nokhacode.userapp.entity.UserEntity;

public class UserMapper {
    public static UserDTO convertUserEntityToUserDTO(UserEntity userEntity){
        return UserDTO.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .createdAt(userEntity.getCreatedAt())
                .modifiedAt(userEntity.getModifiedAt())
                .build();

    }
}
