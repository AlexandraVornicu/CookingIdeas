package org.application.service;

import org.application.model.dtos.IngredientDTO;
import org.application.model.entities.IngredientEntity;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public IngredientEntity mapIngredientDTOtoIngredientEntity(IngredientDTO ingredientDTO) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setName(ingredientDTO.getName());
        ingredientEntity.setQuantity(ingredientDTO.getQuantity());
        return ingredientEntity;
    }

    public IngredientDTO mapIngredientEntityToIngredientDTO(IngredientEntity ingredientEntity) {
        return IngredientDTO.builder().name(ingredientEntity.getName()).quantity(ingredientEntity.getQuantity()).build();

    }
}
