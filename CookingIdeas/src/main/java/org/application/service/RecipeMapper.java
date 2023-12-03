package org.application.service;

import org.application.model.dtos.RecipeCreateDTO;
import org.application.model.dtos.RecipeSearchDTO;
import org.application.model.entities.RecipeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeMapper {
    private final IngredientRecipeMapper ingredientRecipeMapper;

    @Autowired
    RecipeMapper(IngredientRecipeMapper ingredientRecipeMapper) {
        this.ingredientRecipeMapper = ingredientRecipeMapper;
    }
    public RecipeSearchDTO mapRecipeEntityToRecipeSearchDTO(RecipeEntity recipeEntity) {

        RecipeSearchDTO recipeSearchDTO = new RecipeSearchDTO();
        recipeSearchDTO.setId(recipeEntity.getId());
        recipeSearchDTO.setName(recipeEntity.getName());
        recipeSearchDTO.setDuration(recipeEntity.getDuration());
        recipeSearchDTO.setSteps(recipeEntity.getSteps());
        recipeSearchDTO.setIngredientsList(
            recipeEntity.getIngredientsList()
                .stream()
                .map(i -> ingredientRecipeMapper.mapIngredientRecipeEntityToIngredientRecipeSearchDTO(i))
                .collect(Collectors.toList()));
        return recipeSearchDTO;
    }

    public RecipeEntity mapRecipeCreateDTOtoRecipeEntity(RecipeCreateDTO recipeCreateDTO) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(recipeEntity.getId());
        recipeEntity.setName(recipeCreateDTO.getName());
        recipeEntity.setDuration(recipeCreateDTO.getDuration());
        recipeEntity.setSteps(recipeCreateDTO.getSteps());
        recipeEntity.setIngredientsList(
            recipeCreateDTO.getIngredientsList()
                .stream()
                .map(i -> ingredientRecipeMapper.mapIngredientRecipeDTOtoIngredientRecipeEntity(i))
                .collect(Collectors.toList()));
        return recipeEntity;
    }
}
