package com.tajutechgh.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "UserDto model information")
public class UserDto {

    private Long id;

    @Schema(description = "First name of the user", example = "Abdul-Aziz")
    @NotEmpty(message = "First name should not be empty")
    private String firstName;

    @Schema(description = "Last name of the user", example = "Mohammed")
    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

    @Schema(description = "Email of the user", example = "jauraaziz@gmail.com")
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
}
