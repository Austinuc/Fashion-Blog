package com.week9.week_nine_sq012austinuc.controllers;

import com.week9.week_nine_sq012austinuc.dtos.requestDtos.CommentDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.LikeDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.PostDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.PostResponseDto;
import com.week9.week_nine_sq012austinuc.services.PostServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/post")
@AllArgsConstructor
public class PostControllers {
    private final PostServices postServices;

    @GetMapping("/")
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return new ResponseEntity<>(postServices.viewAllPosts(), HttpStatus.OK);
    }
    @PostMapping("/create-post/{userId}")
    public ResponseEntity<PostResponseDto> createAPost(@RequestBody PostDto postDto, @PathVariable Long userId) {
        return new ResponseEntity<>(postServices.createPost(postDto, userId), HttpStatus.CREATED);
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
