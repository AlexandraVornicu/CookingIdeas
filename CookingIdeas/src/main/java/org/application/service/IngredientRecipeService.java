package org.application.service;

import org.application.model.dtos.IngredientRecipeCreateDTO;
import org.application.model.dtos.IngredientRecipeSearchDTO;
import org.application.model.entities.IngredientRecipeEntity;
import org.application.repository.IngredientRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientRecipeService {

    private final IngredientRecipeRepository ingredientRecipeRepository;
    private final IngredientRecipeMapper ingredientRecipeMapper;

    @Autowired
    IngredientRecipeService(IngredientRecipeRepository ingredientRecipeRepository,
                            IngredientRecipeMapper ingredientRecipeMapper) {
        this.ingredientRecipeRepository = ingredientRecipeRepository;
        this.ingredientRecipeMapper = ingredientRecipeMapper;
    }

    public IngredientRecipeSearchDTO createIngredient(IngredientRecipeCreateDTO ingredientRecipeToCreateDTO) {

        IngredientRecipeEntity ingredientRecipeEntity =
            ingredientRecipeMapper.mapIngredientRecipeDTOtoIngredientRecipeEntity(ingredientRecipeToCreateDTO);
        IngredientRecipeEntity createdIngredientRecipeEntity = ingredientRecipeRepository.save(ingredientRecipeEntity);
        return ingredientRecipeMapper.mapIngredientRecipeEntityToIngredientRecipeSearchDTO(createdIngredientRecipeEntity);
    }

    public List<IngredientRecipeSearchDTO> getAllIngredients() {
        List<IngredientRecipeSearchDTO> ingredientRecipeDTOList = new ArrayList<>();
        for (IngredientRecipeEntity ingredientRecipeEntity : ingredientRecipeRepository.findAll()) {
            ingredientRecipeDTOList.add(ingredientRecipeMapper.mapIngredientRecipeEntityToIngredientRecipeSearchDTO(ingredientRecipeEntity));
        }
        return ingredientRecipeDTOList;
    }
}
