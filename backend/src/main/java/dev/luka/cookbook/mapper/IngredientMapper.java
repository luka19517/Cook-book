package dev.luka.cookbook.mapper;

import dev.luka.cookbook.domain.entity.Ingredient;
import dev.luka.cookbook.model.IngredientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    IngredientModel entityToModel(Ingredient ingredient);

    @Mapping(target = "receipt", ignore = true)
    Ingredient modelToEntity(IngredientModel ingredientModel);

    List<IngredientModel> entityToModel(List<Ingredient> ingredients);

    @Mapping(target = "receipt", ignore = true)
    List<Ingredient> modelToEntity(List<IngredientModel> receiptItems);
}
