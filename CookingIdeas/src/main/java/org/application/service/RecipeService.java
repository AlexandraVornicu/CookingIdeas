package org.application.service;

import org.application.model.dtos.RecipeCreateDTO;
import org.application.model.dtos.RecipeSearchDTO;
import org.application.model.entities.RecipeEntity;
import org.application.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    @Autowired
    RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }
    public RecipeSearchDTO createRecipe(RecipeCreateDTO recipeCreateDTO){

        RecipeEntity recipeEntity = recipeMapper.mapRecipeCreateDTOtoRecipeEntity(recipeCreateDTO);
        RecipeEntity createdRecipeEntity = recipeRepository.save(recipeEntity);
        return recipeMapper.mapRecipeEntityToRecipeSearchDTO(createdRecipeEntity);
    }

    public List<RecipeSearchDTO> getAllRecipes() {
        List<RecipeSearchDTO> recipeDTOList = new ArrayList<>();
        for (RecipeEntity recipeEntity : recipeRepository.findAll()) {
            recipeDTOList.add(recipeMapper.mapRecipeEntityToRecipeSearchDTO(recipeEntity));
        }
        return recipeDTOList;
    }
}
