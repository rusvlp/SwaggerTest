package com.example.swaggertest_init.entites;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Product {

    @Schema(
         description = "Product's unique identifier",
         example = "1"
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(
            description = "Product's title",
            example = "Engine Oil Lukoil v1337 from Sergey Maslo"
    )
    private String title;

    @Schema(
            description = "Product's price",
            example = "228"
    )
    private long price;

    @Schema(
            description = "Product's description",
            example = "Sergey Maslo's best quality product"
    )
    private String description;
}
