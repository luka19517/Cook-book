package dev.luka.cookbook.model;

import lombok.Data;

@Data
public class IngredientModel {

    private Long id;
    private String name;
    private Double quantity;
    private String unit;

}
