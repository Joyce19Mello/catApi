package com.cat.dto;

import com.cat.mapper.CatAccessoriesMapper;
import com.cat.model.CatAccessoriesModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CatAccessoriesDTO {

    @JsonProperty("id")
    private String breed;

    @NotNull
    @JsonProperty("url")
    private String image;

    @NotNull
    private String image2;

    @NotNull
    private String image3;

    @NotNull
    private String typeAccessoriesCat;

    public CatAccessoriesModel toEntity() {
        return CatAccessoriesMapper.INSTANCE.catAccessoriesToEntity(this);
    }
}
