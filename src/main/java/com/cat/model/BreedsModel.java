package com.cat.model;

import com.cat.dto.BreedsDTO;
import com.cat.mapper.BreedsMapper;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "catapi", name = "breeds")
@Data
public class BreedsModel {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "temperament")
    private String temperament;

    @Column(name = "breed")
    private String breed;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "picture_url_2")
    private String pictureUrl2;

    @Column(name = "picture_url_3")
    private String pictureUrl3;

    @Column(name = "description")
    @Size(min = 10, max = 1000)
    private String description;

    public BreedsDTO toDto() {
        return BreedsMapper.INSTANCE.breedToBreedDto(this);
    }

}
