package org.application.controller;

import jakarta.validation.Valid;
import org.application.model.dtos.*;
import org.application.model.entities.IngredientRecipeEntity;
import org.application.service.IngredientRecipeMapper;
import org.application.service.IngredientRecipeService;
import org.application.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    private List<RecipeSearchDTO> recipesList;
    private final RecipeService recipeService;
    private final IngredientRecipeService ingredientRecipeService;

    @Autowired
    RecipeController(RecipeService recipeService,
                     IngredientRecipeService ingredientRecipeService) {
        this.recipeService = recipeService;
        this.ingredientRecipeService = ingredientRecipeService;
    }

    @PostMapping(path = "/recipe")
    public ResponseEntity<CustomResponseDTO> createNewRecipe(
        @RequestBody @Valid RecipeCreateDTO recipeCreateDTO,
        BindingResult bindingResult) {

        CustomResponseDTO customResponseDTO = new CustomResponseDTO();

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            StringBuilder errorMessages = new StringBuilder();
            for (FieldError errorMessage : fieldErrors) {
                errorMessages.append(errorMessage.getDefaultMessage()).append(" ");
            }
            customResponseDTO.setResponseObject(null);
            customResponseDTO.setResponseMessage(String.valueOf(errorMessages));
            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
        }

        recipesList = recipeService.getAllRecipes();
        if(recipesList.stream().anyMatch(r -> (r.getName()).equals(recipeCreateDTO.getName()))) {
            customResponseDTO.setResponseObject(null);
            customResponseDTO.setResponseMessage("Reteta exista si trebuie actualizata.");
            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
        }

        RecipeSearchDTO recipeSearchDTO = recipeService.createRecipe(recipeCreateDTO);
        List<IngredientRecipeSearchDTO> ingredientRecipeSearchDTOList = new ArrayList<>();
        for (IngredientRecipeCreateDTO ingredientRecipeCreateDTO: recipeCreateDTO.getIngredientsList()) {
            ingredientRecipeSearchDTOList.add(
                ingredientRecipeService.createIngredient(ingredientRecipeCreateDTO)
            );
        }
        recipeSearchDTO.setIngredientsList(ingredientRecipeSearchDTOList);
        customResponseDTO.setResponseObject(recipeSearchDTO);
        customResponseDTO.setResponseMessage("Reteta creata cu succes.");
        return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping(path = "/recipesfromingredients")
    public List<RecipeSearchDTO> getRecipesFromIngredients() {
        return recipeService.getAllRecipesFromIngredients();
    }
    @GetMapping(path = "/allrecipes")
    public List<RecipeSearchDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}


