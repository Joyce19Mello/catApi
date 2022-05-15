package com.cat.dto;

import com.cat.mapper.CatAccessoriesMapper;
import com.cat.model.CatAccessoriesModel;

public class CatAccessoriesDTO {

    public CatAccessoriesModel toEntity() {
        return CatAccessoriesMapper.INSTANCE.catAccessoriesToEntity(this);
    }
}
