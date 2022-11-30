package com.week9.week_nine_sq012austinuc.dtos.responseDtos;

import com.week9.week_nine_sq012austinuc.dtos.requestDtos.LikeDto;
import lombok.*;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {

    private Long postId;
    private String title;
    private String description;
    private String category;
    private String imageUrl;
    private List<CommentResponseDto> postComments;
    private LikeResponseDto postLikes;
}
