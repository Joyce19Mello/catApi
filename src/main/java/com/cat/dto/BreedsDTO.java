package com.cat.dto;

import com.cat.mapper.BreedsMapper;
import com.cat.model.BreedsModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BreedsDTO {

    @NotNull
    private String origin;

    @NotNull
    @JsonProperty("id")
    private String breed;

    @NotNull
    private String temperament;

    @NotNull
    private String description;

    @NotNull
    @JsonProperty("image")
    private ImageDTO image;

    @NotNull
    private String image2;

    @NotNull
    private String image3;

    public BreedsModel toEntity() {
        return BreedsMapper.INSTANCE.breedToBreedEntity(this);
    }
}
