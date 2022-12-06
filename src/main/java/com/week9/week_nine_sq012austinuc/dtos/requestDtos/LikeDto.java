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
public class LikeDto {

    @NotNull @Schema(example = "austin")
    private String userName;

    @NotNull @Schema(example = "5")
    private Long postId;
}
