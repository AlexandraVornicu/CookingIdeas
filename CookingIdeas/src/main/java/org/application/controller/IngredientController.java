package org.application.controller;

import jakarta.validation.Valid;
import org.application.model.dtos.CustomResponseDTO;
import org.application.model.dtos.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.application.service.IngredientService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IngredientController {

    List<IngredientDTO> ingredientDTOList = new ArrayList<>();
    private final IngredientService ingredientService;

    @Autowired
    IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping(path = "/ingredient")
    public ResponseEntity<CustomResponseDTO> createNewIngredient(@RequestBody @Valid IngredientDTO ingredientDTO,
                                                                 BindingResult bindingResult) {
        CustomResponseDTO customResponseDTO = new CustomResponseDTO();

        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            customResponseDTO.setResponseObject(null);
            customResponseDTO.setResponseMessage(errorMessage);
            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
        }
        ingredientService.createIngredient(ingredientDTO);
        customResponseDTO.setResponseObject(ingredientDTO);
        ingredientDTOList.add(ingredientDTO);
        customResponseDTO.setResponseMessage("Ingredient creat cu succes.");
        return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
    }

}
