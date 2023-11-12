package org.application.repository;

import org.application.model.dtos.IngredientDTO;
import org.application.model.entities.IngredientEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class IngredientRepository {

    private Map<String, Integer> ingredientEntities = new HashMap();

    public IngredientEntity createIngredient(IngredientEntity ingredientToSave) {
        ingredientEntities.put(ingredientToSave.getName(), ingredientToSave.getQuantity());
        return ingredientToSave;
    }

    public Map<String, Integer> getAllIngredients() {
        return ingredientEntities;
    }

    public IngredientEntity updateIngredient(IngredientEntity ingredientToSave) {
        ingredientEntities.replace(ingredientToSave.getName(), ingredientToSave.getQuantity());
        return ingredientToSave;
    }

    public void deleteIngredient(String name) {
        ingredientEntities.remove(name);
    }
}
