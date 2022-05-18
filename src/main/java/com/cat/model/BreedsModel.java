package com.cat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(schema = "catapi", name = "breeds")
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

    public BreedsModel() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BreedsModel that = (BreedsModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
