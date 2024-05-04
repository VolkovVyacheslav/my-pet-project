package com.vokov.catalogue.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(schema= "catalogue", name = "t_product")
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(
        @NamedQuery(
                name = "Product.findAllByTitleLikeIgnoreCase",
        query = "select p from Product p where p.title ilike :filter")
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "c_title")
    private String title;

    @Size(max = 1000)
    @Column(name = "c_detail")
    private String detail;

}
