package com.week9.week_nine_sq012austinuc.controllers;

import com.week9.week_nine_sq012austinuc.dtos.requestDtos.CommentDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.LikeDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.PostDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.PostResponseDto;
import com.week9.week_nine_sq012austinuc.exceptions.InvalidRequestException;
import com.week9.week_nine_sq012austinuc.services.PostServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping(value = "/api/v1/post")
//@AllArgsConstructor
public class PostControllers {

    @Autowired
    private PostServices postServices;

    @Autowired
    public HttpSession httpSession;

    @GetMapping("/")
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return new ResponseEntity<>(postServices.viewAllPosts(), HttpStatus.OK);
    }
    @PostMapping("/create-post/")
    public ResponseEntity<PostResponseDto> createAPost(@RequestBody PostDto postDto) {
        if (httpSession.isNew()) {
            LOGGER.error("User has no session");
            throw new InvalidRequestException("You are not logged in", "Please login in");
        }
        return new ResponseEntity<>(postServices.createPost(postDto, (Long)httpSession.getAttribute("userId")), HttpStatus.CREATED);
    }

    @PostMapping("/comment")
    public ResponseEntity<PostResponseDto> commentOnPost(@RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(postServices.commentOnAPost(commentDto), HttpStatus.CREATED);
    }

    @PostMapping("/like-post")
    public ResponseEntity<PostResponseDto> likeAPost(@RequestBody LikeDto likeDto) {
        return new ResponseEntity<>(postServices.likeAPost(likeDto), HttpStatus.CREATED);
    }
}
