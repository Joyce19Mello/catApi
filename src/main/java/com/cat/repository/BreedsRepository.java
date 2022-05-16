package com.cat.repository;

import com.cat.model.BreedsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BreedsRepository extends JpaRepository<BreedsModel, Long> {
    BreedsModel findByBreed(String breed);

    @Query("Select c from BreedsModel c where c.temperament like %:temperament%")
    List<BreedsModel> findByTemperamentContaining(String temperament);

    @Query("Select c from BreedsModel c where c.origin like %:origin%")
    List<BreedsModel> findByOriginContaining(String origin);
}
