package org.application.repository;

import org.application.model.entities.RecipeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class RecipeRepository {

    private final List<RecipeEntity> recipeEntityList = new ArrayList<>();

    RecipeEntity recipe1 = new RecipeEntity(
        "Baked apples",
        Map.of("apple", 4),
        new String[]{"pas1", "pas2"},
        10);

    public List<RecipeEntity> getAllRecipes() {
        recipeEntityList.add(recipe1);
        return recipeEntityList;
    }

}
