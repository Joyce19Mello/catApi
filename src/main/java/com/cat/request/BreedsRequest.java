package com.cat.request;

import com.cat.mapper.BreedsMapper;
import com.cat.model.BreedsModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BreedsRequest {

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "Egypt",
            value = "Origem da raça do gato")
    private String origin;

    @NotNull
    @JsonProperty("id")
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
    private ImageBean image;

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

    public BreedsModel toEntity() {
        return BreedsMapper.INSTANCE.breedToBreedEntity(this);
    }
}
