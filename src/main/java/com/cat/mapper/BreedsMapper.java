package com.cat.mapper;

import com.cat.request.BreedsRequest;
import com.cat.model.BreedsModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BreedsMapper {
    BreedsMapper INSTANCE = Mappers.getMapper(BreedsMapper.class);
    BreedsModel breedToBreedEntity(BreedsRequest breedsRequest);
    BreedsRequest breedToBreedRequest(BreedsModel breedsModel);
}
