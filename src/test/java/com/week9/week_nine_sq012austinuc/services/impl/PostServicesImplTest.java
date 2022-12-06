package com.week9.week_nine_sq012austinuc.services.impl;

import com.week9.week_nine_sq012austinuc.dtos.requestDtos.CommentDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.PostDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UserLoginDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.UsersDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.PostResponseDto;
import com.week9.week_nine_sq012austinuc.models.Post;
import com.week9.week_nine_sq012austinuc.models.Users;
import com.week9.week_nine_sq012austinuc.repository.PostCommentRepository;
import com.week9.week_nine_sq012austinuc.repository.PostLikeRepository;
import com.week9.week_nine_sq012austinuc.repository.PostRepository;
import com.week9.week_nine_sq012austinuc.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class PostServicesImplTest {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PostRepository postRepository;
    @Autowired
    UsersServicesImpl usersServices;
    @Autowired
    PostServicesImpl postServices;
    @Autowired
    PostCommentRepository postCommentRepository;
    @Autowired
    PostLikeRepository postLikeRepository;

    UsersDto admin = new UsersDto();
    List<Post> postList = new ArrayList<>();

    PostDto postDto = new PostDto();
    UsersDto customer = new UsersDto();
    PostResponseDto postResponseDto = new PostResponseDto();

    @BeforeEach
    public void setUp() {
        admin = UsersDto.builder()
                .email("austin1@gmail.com")
                .firstName("Uche")
                .lastName("Igboke")
                .userName("austinuc")
                .password("1234")
                .confirmPassword("1234")
                .phoneNumber("0908467324")
                .build();


        customer = UsersDto.builder()
                .email("customer@gmail.com")
                .firstName("Collins")
                .lastName("Ik")
                .userName("collinsIk")
                .password("1234")
                .confirmPassword("1234")
                .phoneNumber("0908467324")
                .build();

        postDto = PostDto.builder()
                .title("Ankara")
                .description("Ankara description")
                .category("Hand Sown")
                .build();
        postList = postRepository.findAll();

    }



    @Test
    void createPost() {
        usersServices.createAdmin(admin);
        UserLoginDto userLoginDto = new UserLoginDto();
        BeanUtils.copyProperties(admin, userLoginDto);

        Users owner = usersRepository.findByEmail(admin.getEmail());
        usersServices.login(userLoginDto);
        postResponseDto = postServices.createPost(postDto, owner.getUserId());
        Assertions.assertNotNull(postResponseDto);

        usersRepository.deleteByEmail(admin.getEmail());
    }

//    @Test
//    void viewAllPosts() {
//    }

    @Test
    void commentOnAPost() {
//        usersServices.logout();
        usersServices.createUser(customer);


        UserLoginDto userLoginDto = new UserLoginDto();
        BeanUtils.copyProperties(customer, userLoginDto);
        usersServices.login(userLoginDto);

        CommentDto commentDto = CommentDto.builder()
                .postId(postList.get(0).getPostId())
                .userName(customer.getUserName())
                .description("Comment description").build();

        postServices.commentOnAPost(commentDto);

        usersRepository.deleteByEmail(customer.getEmail());

    }

//    @Test
//    void likeAPost() {
//    }
//
//    @Test
//    void getPostComments() {
//    }
//
//    @Test
//    void getPostLikes() {
//    }

    @AfterEach
    public void tearDown() {

    }
}