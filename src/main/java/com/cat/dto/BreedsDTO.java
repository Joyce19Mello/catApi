package com.cat.dto;

import com.cat.mapper.BreedsMapper;
import com.cat.model.BreedsModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BreedsDTO {

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "Egypt",
            value = "Origem do cat")
    private String origin;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "POUPANCA",
            value = "tipo da conta em que o saldo que será adicionado")
    private String temperament;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "POUPANCA",
            value = "tipo da conta em que o saldo que será adicionado")
    private String description;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "POUPANCA",
            value = "tipo da conta em que o saldo que será adicionado")
    private String picture1;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "POUPANCA",
            value = "tipo da conta em que o saldo que será adicionado")
    private String picture2;

    @NotNull
    @ApiModelProperty(
            required = true,
            example = "POUPANCA",
            value = "tipo da conta em que o saldo que será adicionado")
    private String picture3;

    public BreedsModel toEntity() {
        return BreedsMapper.INSTANCE.breedToBreedEntity(this);
    }
}
