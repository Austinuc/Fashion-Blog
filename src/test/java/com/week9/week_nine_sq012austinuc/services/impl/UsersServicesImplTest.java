//package com.week9.week_nine_sq012austinuc.services.impl;
//
//import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UsersDto;
//import com.week9.week_nine_sq012austinuc.repository.UsersRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UsersServicesImplTest {
//
//    @Autowired
//    UsersServicesImpl usersServices;
//
//    @Autowired
//    UsersRepository usersRepository;
//
//    UsersDto usersDto;
//
//    @BeforeEach
//    public void setUp() {
//        usersDto = UsersDto.builder()
//                .email("austin1@gmail.com")
//                .firstName("Uche")
//                .lastName("Igboke")
//                .userName("austinuc")
//                .password("1234")
//                .confirmPassword("1234")
//                .phoneNumber("0908467324")
//                .build();
//    }
//
//    @Test
//    void createAdminTest() {
//        assertEquals(usersServices.createAdmin(usersDto).getRole(), "ADMIN");
//    }
//
//    @Test
//    void createUser() {
//        assertEquals(usersServices.createUser(usersDto).getRole(), "CUSTOMER");
//    }
//
//    @AfterEach
//    void tearDown() {
//        usersRepository.deleteByEmail(usersDto.getEmail());
//    }
//}