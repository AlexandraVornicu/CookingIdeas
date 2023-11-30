package org.application.service;

import org.application.model.dtos.IngredientCreateDTO;
import org.application.model.dtos.IngredientSearchDTO;
import org.application.model.entities.IngredientEntity;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public IngredientEntity mapIngredientDTOtoIngredientEntity(IngredientCreateDTO ingredientDTO) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setName(ingredientDTO.getName());
        ingredientEntity.setQuantity(ingredientDTO.getQuantity());
        return ingredientEntity;
    }

    public IngredientCreateDTO mapIngredientEntityToIngredientDTO(IngredientEntity ingredientEntity) {
        return IngredientCreateDTO.builder().name(ingredientEntity.getName()).quantity(ingredientEntity.getQuantity()).build();

    }

    public IngredientSearchDTO mapIngredientEntityToUserSearchDTO(IngredientEntity ingredientEntity) {
        return IngredientSearchDTO.builder().id(ingredientEntity.getId()).name(ingredientEntity.getName()).quantity(ingredientEntity.getQuantity()).build();
    }
}
