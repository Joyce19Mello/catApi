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

    @Column(name = "breed")
    private String breed;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "picture_url_2")
    private String pictureUrl2;

    @Column(name = "picture_url_3")
    private String pictureUrl3;

    @Column(name = "type_accessorie")
    private String typeAccessoriesCat;


    public CatAccessoriesDTO toDTO() {
        return CatAccessoriesMapper.INSTANCE.catAccessoriesToDTO(this);
    }
}
