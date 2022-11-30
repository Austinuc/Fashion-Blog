package com.week9.week_nine_sq012austinuc.dtos.responseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String role;
    private String email;
    private String phoneNumber;
}
