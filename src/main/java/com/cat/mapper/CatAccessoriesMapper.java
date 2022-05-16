package com.cat.mapper;

import com.cat.request.CatAccessoriesRequest;
import com.cat.model.CatAccessoriesModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CatAccessoriesMapper {
    CatAccessoriesMapper INSTANCE = Mappers.getMapper(CatAccessoriesMapper.class);
    CatAccessoriesRequest catAccessoriesToRequest(CatAccessoriesModel breed);
    CatAccessoriesModel catAccessoriesToEntity(CatAccessoriesRequest breedsDTO);
}
