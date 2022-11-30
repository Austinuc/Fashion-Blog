package com.week9.week_nine_sq012austinuc.services.impl;

import com.week9.week_nine_sq012austinuc.enums.UserRole;
import com.week9.week_nine_sq012austinuc.exceptions.InvalidRequestException;
import com.week9.week_nine_sq012austinuc.models.Users;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UserLoginDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.UserResponseDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UsersDto;
import com.week9.week_nine_sq012austinuc.repository.UsersRepository;
import com.week9.week_nine_sq012austinuc.services.UsersServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


//@Slf4j
@AllArgsConstructor
@Service
public class UsersServicesImpl implements UsersServices {


    private final UsersRepository usersRepository;

    @Override
    public UserResponseDto createAdmin(UsersDto usersDto) {
        Users admin = new Users();
        if (!usersDto.getPassword().equals(usersDto.getConfirmPassword())) {
//            log.error("Admin password mismatch");
            throw new InvalidRequestException("Password mismatch", "Your password must match. Try again");
        }
        admin.setRole(UserRole.ADMIN.name());
        return getUserResponseDto(usersDto, admin);
    }

    @Override
    public UserResponseDto createUser(UsersDto usersDto) {

        Users customer = new Users();
        if (!usersDto.getPassword().equals(usersDto.getConfirmPassword())) {
//            log.error("Customer password mismatch");
            throw new InvalidRequestException("Password mismatch", "Your password must match. Try again");
        }
        customer.setRole(UserRole.CUSTOMER.name());
        return getUserResponseDto(usersDto, customer);
    }

    private UserResponseDto getUserResponseDto(UsersDto usersDto, Users admin) {
        BeanUtils.copyProperties(usersDto, admin);

        try {
            admin = usersRepository.save(admin);
        } catch (Exception e) {
//            log.error("Encountered error trying to register admin");
            throw new InvalidRequestException(e.getMessage(), "Please try again");
        }
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(admin, userResponseDto);

        return userResponseDto;
    }

    @Override
    public UserResponseDto login(UserLoginDto usersLoginDto) {
        Users user = usersRepository.findByEmailAndPassword(usersLoginDto.getEmail(), usersLoginDto.getPassword())
                .orElseThrow(() -> new InvalidRequestException("No account with your details exists", "signup or try again"));
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);

        return userResponseDto;
    }
}
