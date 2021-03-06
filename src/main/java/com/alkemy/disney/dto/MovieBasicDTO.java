package com.alkemy.disney.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MovieBasicDTO {
    @NotNull
    private String image;
    @NotNull
    private String title;

    private String creationDate;
}
