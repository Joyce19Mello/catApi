package com.cat.repository;

import com.cat.model.BreedsModel;
import com.cat.model.CatAccessoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatAccessoriesRepository extends JpaRepository<CatAccessoriesModel, Long> {

}
