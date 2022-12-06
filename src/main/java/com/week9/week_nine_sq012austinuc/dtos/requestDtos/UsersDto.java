package com.week9.week_nine_sq012austinuc.dtos.requestDtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    @NotNull @Schema(example = "Austin")
    private String firstName;
    @NotNull @Schema(example = "Igboke")
    private String lastName;
    @NotNull @Schema(example = "austin")
    private String userName;

    @NotNull @Schema(example = "austin@gmail.com")
    private String email;
    @NotNull @Schema(example = "1234")
    private String password;
    @NotNull @Schema(example = "1234")
    private String confirmPassword;

    @NotNull @Schema(example = "09063777946")
    private String phoneNumber;
}
