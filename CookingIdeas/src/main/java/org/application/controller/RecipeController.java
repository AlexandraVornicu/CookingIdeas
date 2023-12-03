package org.application.controller;

import jakarta.validation.Valid;
import org.application.model.dtos.CustomResponseDTO;
import org.application.model.dtos.RecipeCreateDTO;
import org.application.model.dtos.RecipeSearchDTO;
import org.application.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private List<RecipeSearchDTO> recipesList;
    private final RecipeService recipeService;

    @Autowired
    RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
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
        customResponseDTO.setResponseObject(recipeSearchDTO);
        customResponseDTO.setResponseMessage("Reteta creata cu succes.");
        return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
    }
}
