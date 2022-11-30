package com.week9.week_nine_sq012austinuc.services;

import com.week9.week_nine_sq012austinuc.dtos.requestDtos.CommentDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.LikeDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.PostDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.CommentResponseDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.LikeResponseDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.PostResponseDto;

import java.util.List;

public interface PostServices {

    PostResponseDto createPost(PostDto postDto, Long userId);
    List<PostResponseDto> viewAllPosts();
    PostResponseDto commentOnAPost(CommentDto commentDto);
    PostResponseDto likeAPost(LikeDto likeDto);

    List<CommentResponseDto> getPostComments(Long postId);
    LikeResponseDto getPostLikes(Long postId);
}
