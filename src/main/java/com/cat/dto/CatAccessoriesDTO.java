package com.cat.dto;

import com.cat.model.CatAccessoriesModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CatAccessoriesDTO {

    @ApiModelProperty(
            required = true,
            example = "1",
            value = "Indicador")
    private Long id;

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

    public static CatAccessoriesDTO converter(CatAccessoriesModel model) {
        CatAccessoriesDTO dto = new CatAccessoriesDTO();
        dto.setId(model.getId());
        dto.setBreed(model.getBreed());
        dto.setImage(model.getPictureUrl());
        dto.setImage2(model.getPictureUrl2());
        dto.setImage3(model.getPictureUrl2());

        return dto;
    }
}
