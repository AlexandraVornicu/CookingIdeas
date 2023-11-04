package org.application.service;

import org.application.model.dtos.IngredientDTO;
import org.application.model.entities.IngredientEntity;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public IngredientEntity mapIngredientDTOtoIngredientEntity(IngredientDTO ingredientDTO) {
        return new IngredientEntity(ingredientDTO.getName(), ingredientDTO.getQuantity());
    }

    public IngredientDTO mapIngredientEntityToIngredientDTO(IngredientEntity ingredientEntity) {
        return new IngredientDTO(ingredientEntity.getName(), ingredientEntity.getQuantity());
    }
}
