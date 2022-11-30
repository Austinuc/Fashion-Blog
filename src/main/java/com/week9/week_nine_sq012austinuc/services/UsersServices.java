package com.week9.week_nine_sq012austinuc.services;

import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UserLoginDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.UserResponseDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UsersDto;

public interface UsersServices {

    UserResponseDto createAdmin(UsersDto usersDto);
    UserResponseDto createUser(UsersDto usersDto);
    UserResponseDto login(UserLoginDto usersLoginDto);
}
