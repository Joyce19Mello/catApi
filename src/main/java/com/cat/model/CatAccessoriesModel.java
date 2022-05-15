package com.cat.model;

import com.cat.dto.CatAccessoriesDTO;
import com.cat.mapper.CatAccessoriesMapper;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "catapi", name = "cat_accessories")
@Data
public class CatAccessoriesModel {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "typeAccessorie")
    private TypeAccessoriesCat typeAccessorie;

    @Column(name = "url")
    private String url;

    public CatAccessoriesDTO toDTO() {
        return CatAccessoriesMapper.INSTANCE.catAccessoriesToDTO(this);
    }
}
