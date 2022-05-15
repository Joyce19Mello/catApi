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

    @Column(name = "description")
    @Size(min = 10, max = 1000)
    private String description;

    @Column(name = "picture1")
    private String picture1;

    @Column(name = "picture2")
    private String picture2;

    @Column(name = "picture3")
    private String picture3;

    public BreedsDTO toDto() {
        return BreedsMapper.INSTANCE.breedToBreedDto(this);
    }


}
