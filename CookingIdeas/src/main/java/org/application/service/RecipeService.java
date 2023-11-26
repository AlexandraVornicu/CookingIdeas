package org.application.service;

import org.application.model.entities.RecipeEntity;
import org.application.repository.IngredientRepository;
import org.application.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<RecipeEntity> getAllRecipes(){
        List<RecipeEntity> allRecipes = recipeRepository.getAllRecipes();
        Map<String, Integer> allIngredients = ingredientRepository.getAllIngredients();

        //logic

        for(RecipeEntity entry: allRecipes) {
            Map<String, Integer> allIngredientsfromRecipe = entry.getIngredientsAndQuantity();

//            if (allIngredients.containsKey(entry.getName()) &&
//                allIngredients.get(entry.getName()) == entry.getIngredientsAndQuantity()) {
//
//            }
        }


        return recipeRepository.getAllRecipes();
    }
}
