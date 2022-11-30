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
public class UserLoginDto {
    @NotNull @Schema(example = "austin@gmail.com")
    private String email;
    @NotNull @Schema(example = "1234")
    private String password;
}
