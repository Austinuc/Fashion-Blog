package com.week9.week_nine_sq012austinuc.controllers;

import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UserLoginDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UsersDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.ApiResponseEntity;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.UserResponseDto;
import com.week9.week_nine_sq012austinuc.services.UsersServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/")
@AllArgsConstructor
public class UsersController {

    private final UsersServices usersServices;

    @PostMapping("admin/create-account")
    public ApiResponseEntity<UserResponseDto> adminSignup(@RequestBody UsersDto usersDto) {
        UserResponseDto userResponseDto = usersServices.createAdmin(usersDto);
        return new ApiResponseEntity<>(userResponseDto, "Admin created successfully", HttpStatus.CREATED);
    }

    @PostMapping("create-account")
    public ApiResponseEntity<UserResponseDto> userSignup(@RequestBody UsersDto usersDto) {

        UserResponseDto userResponseDto = usersServices.createUser(usersDto);
        return new ApiResponseEntity<>(userResponseDto, "Customer account created successfully", HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ApiResponseEntity<UserResponseDto> userLogin(@RequestBody UserLoginDto userLoginDto) {

        UserResponseDto userResponseDto = usersServices.login(userLoginDto);
        return new ApiResponseEntity<>(userResponseDto, "Login was successful", HttpStatus.ACCEPTED);
    }

    @GetMapping("logout")
    public ApiResponseEntity<String> userLogout() {

        return new ApiResponseEntity<>(usersServices.logout(), "Login again to proceed", HttpStatus.OK);
    }
}
