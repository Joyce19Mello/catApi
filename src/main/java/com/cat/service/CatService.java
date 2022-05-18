package com.cat.service;

import com.cat.dto.BreedsDTO;
import com.cat.model.BreedsModel;
import com.cat.model.CatAccessoriesModel;
import com.cat.repository.BreedsRepository;
import com.cat.repository.CatAccessoriesRepository;
import com.cat.request.BreedsRequest;
import com.cat.request.CatAccessoriesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CatService {

    @Autowired
    private BreedsRepository breedsRepository;

    @Autowired
    private CatAccessoriesRepository catAccessoriesRepository;

    public List<BreedsModel> findAll() {
        return breedsRepository.findAll();
    }

    public BreedsDTO findByBreed(String breed) {
        return BreedsDTO.converter(breedsRepository.findByBreed(breed));
    }

    public List<BreedsModel> findByTemperamentContaining(String temperament) {
        return breedsRepository.findByTemperamentContaining(temperament);
    }

    public List<BreedsModel> findByOriginContaining(String origin) {
        return breedsRepository.findByOriginContaining(origin);
    }

    public BreedsModel save(BreedsRequest request) {
        log.info("Iniciando salvamento na base de dados");
        return breedsRepository.save(request.toEntity());
    }

    public CatAccessoriesModel saveCatAccessories(CatAccessoriesRequest request) {
        log.info("Iniciando salvamento na base de dados");
        return catAccessoriesRepository.save(request.toEntity());
    }
}
