package com.cat.mapper;

import com.cat.dto.CatAccessoriesDTO;
import com.cat.model.CatAccessoriesModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CatAccessoriesMapper {
    CatAccessoriesMapper INSTANCE = Mappers.getMapper(CatAccessoriesMapper.class);
    CatAccessoriesDTO catAccessoriesToDTO(CatAccessoriesModel breed);
    CatAccessoriesModel catAccessoriesToEntity(CatAccessoriesDTO breedsDTO);
}
