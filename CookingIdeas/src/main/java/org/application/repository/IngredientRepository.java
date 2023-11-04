package org.application.repository;

import org.application.model.dtos.IngredientDTO;
import org.application.model.entities.IngredientEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {

    private List<IngredientEntity> ingredientEntities = new ArrayList<>();

    public IngredientEntity createIngredient(IngredientEntity ingredientToSave) {
        ingredientEntities.add(ingredientToSave);
        return ingredientToSave;
    }

    public List<IngredientEntity> getAllIngredients() {
        return ingredientEntities;
    }
}
