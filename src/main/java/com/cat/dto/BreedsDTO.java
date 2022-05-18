package com.cat.dto;

import com.cat.model.BreedsModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class BreedsDTO {

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "1",
            value = "Identificador")
    private Long id;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "Egypt",
            value = "Origem da raça do gato")
    private String origin;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "abys",
            value = "Raça")
    private String breed;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "[Intelligent, Gentle]",
            value = "Temperamento da raça gato")
    private String temperament;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "Fácil de cuidar e afetuoso",
            value = "Informações do gato")
    private String description;

    @NotNull
    @JsonProperty("image")
    @ApiModelProperty(
            required = true,
            example = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
            value = "Objeto para pegar url da primeira imagem provinda da raça")
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

    public static BreedsDTO converter(BreedsModel model) {
        BreedsDTO dto = new BreedsDTO();
        dto.setId(model.getId());
        dto.setBreed(model.getBreed());
        dto.setTemperament(model.getTemperament());
        dto.setOrigin(model.getOrigin());
        dto.setDescription(model.getDescription());
        dto.setImage(model.getPictureUrl());
        dto.setImage2(model.getPictureUrl2());
        dto.setImage3(model.getPictureUrl2());

        return dto;
    }
}
