package com.cat.repository;

import com.cat.model.CatAccessoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CatAccessoriesRepository extends JpaRepository<CatAccessoriesModel, Long> {
    List<CatAccessoriesModel> findByTypeAccessoriesCat(String typeAccessoriesCat);
}
