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
public class PostDto {

    @NotNull @Schema(example = "Designer shirt")
    private String title;

    @NotNull @Schema(example = "Describe your post contents here")
    private String description;

    @NotNull @Schema(example = "Ankara | Shirt | Trousers")
    private String category;

    @NotNull @Schema(example = "https://imageurl.com")
    private String imageUrl;
}
