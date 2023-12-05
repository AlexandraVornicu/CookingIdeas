package org.application.service;

import org.application.model.dtos.IngredientRecipeCreateDTO;
import org.application.model.dtos.IngredientRecipeSearchDTO;
import org.application.model.entities.IngredientRecipeEntity;
import org.springframework.stereotype.Component;

@Component
public class IngredientRecipeMapper {

    public IngredientRecipeEntity mapIngredientRecipeDTOtoIngredientRecipeEntity(IngredientRecipeCreateDTO ingredientRecipeDTO) {
        IngredientRecipeEntity ingredientRecipeEntity = new IngredientRecipeEntity();
        ingredientRecipeEntity.setName(ingredientRecipeDTO.getName());
        ingredientRecipeEntity.setQuantity(ingredientRecipeDTO.getQuantity());
        return ingredientRecipeEntity;
    }

    public IngredientRecipeCreateDTO mapIngredientRecipeEntityToIngredientRecipeDTO(IngredientRecipeEntity ingredientRecipeEntity) {
        return IngredientRecipeCreateDTO.builder().name(ingredientRecipeEntity.getName()).quantity(ingredientRecipeEntity.getQuantity()).build();

    }

    public IngredientRecipeSearchDTO mapIngredientRecipeEntityToIngredientRecipeSearchDTO(IngredientRecipeEntity ingredientRecipeEntity) {
        return IngredientRecipeSearchDTO.builder().id(ingredientRecipeEntity.getId()).name(ingredientRecipeEntity.getName()).quantity(ingredientRecipeEntity.getQuantity()).build();
    }
}
