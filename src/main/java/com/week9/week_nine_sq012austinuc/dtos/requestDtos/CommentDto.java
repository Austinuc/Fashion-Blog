package com.week9.week_nine_sq012austinuc.dtos.requestDtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    @NotNull @Schema(example = "3")
    private Long postId;

    @NotNull @Schema(example = "Uche")
    private String firstName;

    @NotNull @Schema(example = "commenter@email.com")
    private String email;

    @NotNull @Schema(example = "type your comments here...")
    private String description;
}
