package com.nokhacode.userapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String email;

    private String firstName;

    private String lastName;

    @CreatedDate
    private Timestamp createdAt;

    private Timestamp modifiedAt;
}
