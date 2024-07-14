package com.nokhacode.userapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPasswordDTO {
    @NotNull
    private Long id;

    @NotNull @NotEmpty
    private String oldPassword;

    @NotNull @NotEmpty
    private String newPassword;
}
