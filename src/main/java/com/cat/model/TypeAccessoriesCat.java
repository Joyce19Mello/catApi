package com.cat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeAccessoriesCat {

    GLASSES("OCULOS"),
    HAT("CHAPEU");

    private String description;

}
