package org.application.service;

import org.application.model.dtos.*;
import org.application.model.entities.IngredientRecipeEntity;
import org.application.model.entities.RecipeEntity;
import org.application.repository.IngredientRecipeRepository;
import org.application.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final IngredientService ingredientService;
    private final IngredientRecipeRepository ingredientRecipeRepository;

    @Autowired
    RecipeService(RecipeRepository recipeRepository,
                  RecipeMapper recipeMapper,
                  IngredientService ingredientService,
                  IngredientRecipeRepository ingredientRecipeRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
        this.ingredientService = ingredientService;
        this.ingredientRecipeRepository = ingredientRecipeRepository;
    }
    public RecipeSearchDTO createRecipe(RecipeCreateDTO recipeCreateDTO){

        RecipeEntity recipeEntity = recipeMapper.mapRecipeCreateDTOtoRecipeEntity(recipeCreateDTO);
        RecipeEntity createdRecipeEntity = recipeRepository.save(recipeEntity);
        List<IngredientRecipeEntity> ingredientRecipeEntityList = createdRecipeEntity.getIngredientsList();
        for (IngredientRecipeEntity ingredient : ingredientRecipeEntityList) {
            ingredientRecipeRepository.save(ingredient);
        }
        return recipeMapper.mapRecipeEntityToRecipeSearchDTO(createdRecipeEntity);
    }

    public List<RecipeSearchDTO> getAllRecipes() {
        List<RecipeSearchDTO> recipeDTOList = new ArrayList<>();
        for (RecipeEntity recipeEntity : recipeRepository.findAll()) {

            RecipeSearchDTO recipeSearchDTO = recipeMapper.mapRecipeEntityToRecipeSearchDTO(recipeEntity);

            List<IngredientRecipeSearchDTO> ingredientRecipeSearchDTOList = new ArrayList<>();

            for (IngredientRecipeSearchDTO ingredientRecipeSearchDTO: recipeSearchDTO.getIngredientsList()) {
                ingredientRecipeSearchDTOList.add(ingredientRecipeSearchDTO);
            }
            recipeSearchDTO.setIngredientsList(ingredientRecipeSearchDTOList);

            recipeDTOList.add(recipeSearchDTO);
        }

        return recipeDTOList;
    }

    public List<RecipeSearchDTO> getAllRecipesFromIngredients() {

        List<RecipeSearchDTO> recipeDTOList = new ArrayList<>();
        List<RecipeSearchDTO> recipeFromIngredientsList = new ArrayList<>();

        for (RecipeEntity recipeEntity : recipeRepository.findAll()) {
            recipeDTOList.add(recipeMapper.mapRecipeEntityToRecipeSearchDTO(recipeEntity));
        }

        List<IngredientSearchDTO> ingredients = ingredientService.getAllIngredients();
        for (RecipeSearchDTO recipe : recipeDTOList) {
            List<IngredientRecipeSearchDTO> ingredientsRecipeList = recipe.getIngredientsList();
            boolean missingIngredient = false;
            for (IngredientRecipeSearchDTO ingredientRecipe : ingredientsRecipeList) {
                for (IngredientSearchDTO ingredient : ingredients) {
                    if (!ingredientRecipe.getName().equals(ingredient.getName())) {
                        missingIngredient = true;
                        System.out.println(missingIngredient);
                        break;
                    }
                }
            }
            if (!missingIngredient) {
                recipeFromIngredientsList.add(recipe);
            }
        }
        return recipeFromIngredientsList;
    }
}
