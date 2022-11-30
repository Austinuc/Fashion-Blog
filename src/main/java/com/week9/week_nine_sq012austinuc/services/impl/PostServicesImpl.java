package com.week9.week_nine_sq012austinuc.services.impl;

import com.week9.week_nine_sq012austinuc.dtos.responseDtos.CommentResponseDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.LikeResponseDto;
import com.week9.week_nine_sq012austinuc.exceptions.InvalidRequestException;
import com.week9.week_nine_sq012austinuc.models.Post;
import com.week9.week_nine_sq012austinuc.models.PostComment;
import com.week9.week_nine_sq012austinuc.models.PostLike;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.CommentDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.LikeDto;
import com.week9.week_nine_sq012austinuc.dtos.requestDtos.PostDto;
import com.week9.week_nine_sq012austinuc.dtos.responseDtos.PostResponseDto;
import com.week9.week_nine_sq012austinuc.repository.PostCommentRepository;
import com.week9.week_nine_sq012austinuc.repository.PostLikeRepository;
import com.week9.week_nine_sq012austinuc.repository.PostRepository;
import com.week9.week_nine_sq012austinuc.repository.UsersRepository;
import com.week9.week_nine_sq012austinuc.services.PostServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServicesImpl implements PostServices {

    private final UsersRepository usersRepository;
    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;
    private final PostLikeRepository postLikeRepository;

    @Override
    public PostResponseDto createPost(PostDto postDto, Long userId) {
        usersRepository.findByUserIdAndRole(userId, "ADMIN")
                .orElseThrow(() -> new InvalidRequestException("You are not permitted to create posts", "contact admin"));

        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        try {
            post = postRepository.save(post);
        } catch (Exception e) {
            throw new InvalidRequestException(e.getMessage(), "Try again");
        }
        PostResponseDto postResponseDto = new PostResponseDto();
        BeanUtils.copyProperties(post, postResponseDto);

        return postResponseDto;
    }

    @Override
    public List<PostResponseDto> viewAllPosts() {

           return postRepository.findAll().stream()
                   .map(post -> PostResponseDto
                           .builder()
                           .title(post.getTitle())
                           .description(post.getDescription())
                           .category(post.getCategory())
                           .imageUrl(post.getImageUrl())
                           .postId(post.getPostId())
                           .postComments(getPostComments(post.getPostId()))
                           .postLikes(getPostLikes(post.getPostId()))
                           .build())
                   .collect(Collectors.toList());
    }

    @Override
    public PostResponseDto commentOnAPost(CommentDto commentDto) {
        PostComment comment = new PostComment();
        BeanUtils.copyProperties(commentDto, comment);
        if (comment.getFirstName().isEmpty()) {
            comment.setFirstName("Anonymous");
        }

        Post post = postRepository.findById(commentDto.getPostId())
                .orElseThrow(() -> new InvalidRequestException("Invalid post Id", "contact front end dev"));

        comment.setPost(post);
        try {
            postCommentRepository.save(comment);
        } catch (Exception e) {
            throw new InvalidRequestException(e.getMessage(), "Try again");
        }
        PostResponseDto postResponseDto = new PostResponseDto();
        BeanUtils.copyProperties(post, postResponseDto);
        postResponseDto.setPostComments(getPostComments(post.getPostId()));
        postResponseDto.setPostLikes(getPostLikes(post.getPostId()));

        return postResponseDto;
    }

    @Override
    public PostResponseDto likeAPost(LikeDto likeDto) {
        Post post = postRepository.findById(likeDto.getPostId()).orElse(new Post());
        PostLike like = PostLike.builder()
                .email(likeDto.getEmail())
                .postId(likeDto.getPostId())
                .build();
        if (postLikeRepository.existsByEmailAndPostId(like.getEmail(), post.getPostId())) {
            postLikeRepository.deletePostLikeByEmailAndPostId(like.getEmail(), post.getPostId());
        } else {
            postLikeRepository.save(like);
        }
        PostResponseDto postResponseDto = new PostResponseDto();

        BeanUtils.copyProperties(post, postResponseDto);
        postResponseDto.setPostComments(getPostComments(post.getPostId()));
        postResponseDto.setPostLikes(getPostLikes(post.getPostId()));

        return postResponseDto;
    }

    @Override
    public List<CommentResponseDto> getPostComments(Long postId) {
        Post post = Post.builder().postId(postId).build();
        return postCommentRepository.findAllByPost(post).stream()
                .map(comment -> CommentResponseDto.builder()
                        .firstName(comment.getFirstName())
                        .description(comment.getDescription())
                        .commentId(comment.getCommentId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public LikeResponseDto getPostLikes(Long postId) {
        Integer likes = Math.toIntExact(postLikeRepository.findAllByPostId(postId).stream()
                .map(PostLike::getLikeId).count());

        return LikeResponseDto.builder().likeCount(likes).build();
    }
}
