package com.cat.request;

import com.cat.mapper.CatAccessoriesMapper;
import com.cat.model.CatAccessoriesModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CatAccessoriesRequest {

    @JsonProperty("id")
    @ApiModelProperty(
            required = true,
            example = "abys",
            value = "Raça")
    private String breed;

    @NotNull
    @JsonProperty("url")
    @ApiModelProperty(
            required = true,
            example = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
            value = "url da primeira imagem de uma específica raça")
    private String image;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
            value = "url da segunda imagem de uma específica raça")
    private String image2;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
            value = "url da terceira imagem de uma específica raça")
    private String image3;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "[OCULOS, CHAPEU]",
            value = "qual tipo de acessório o gato usa")
    private String typeAccessoriesCat;

    public CatAccessoriesModel toEntity() {
        return CatAccessoriesMapper.INSTANCE.catAccessoriesToEntity(this);
    }
}
