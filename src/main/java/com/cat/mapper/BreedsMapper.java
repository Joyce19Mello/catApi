package com.cat.mapper;

import com.cat.dto.BreedsDTO;
import com.cat.model.BreedsModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BreedsMapper {
    BreedsMapper INSTANCE = Mappers.getMapper(BreedsMapper.class);
    BreedsDTO breedToBreedDto(BreedsModel breed);
    BreedsModel breedToBreedEntity(BreedsDTO breedsDTO);
}
