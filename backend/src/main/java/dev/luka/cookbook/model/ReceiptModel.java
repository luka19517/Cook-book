package dev.luka.cookbook.model;

import lombok.Data;

import java.util.List;

@Data
public class ReceiptModel {

    private Long id;
    private String name;
    private ReceiptTypeModel type;
    private List<IngredientModel> ingredients;
    private String description;
}
