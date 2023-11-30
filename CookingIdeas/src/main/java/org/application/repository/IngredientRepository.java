package org.application.repository;

import org.application.model.entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

   // private Map<String, Integer> ingredientEntities = new HashMap<>();

//    public IngredientEntity createIngredient(IngredientEntity ingredientToSave) {
//        ingredientEntities.put(ingredientToSave.getName(), ingredientToSave.getQuantity());
//        return ingredientToSave;
//    }

//    public Map<String, Integer> getAllIngredients() {
//        return ingredientEntities;
//    }

//    public IngredientEntity updateIngredient(IngredientEntity ingredientToSave) {
//        ingredientEntities.replace(ingredientToSave.getName(), ingredientToSave.getQuantity());
//        return ingredientToSave;
//    }

//    public void deleteIngredient(String name) {
//        ingredientEntities.remove(name);
//    }
}
