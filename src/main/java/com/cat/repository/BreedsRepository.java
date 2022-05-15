package com.cat.repository;

import com.cat.model.BreedsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedsRepository extends JpaRepository<BreedsModel, Long> {

}
