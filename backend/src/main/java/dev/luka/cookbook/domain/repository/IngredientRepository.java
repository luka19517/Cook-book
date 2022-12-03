package dev.luka.cookbook.domain.repository;

import dev.luka.cookbook.domain.entity.Ingredient;
import dev.luka.cookbook.domain.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
