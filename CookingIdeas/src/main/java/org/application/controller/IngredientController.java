package org.application.controller;

import jakarta.validation.Valid;
import org.application.model.dtos.CustomResponseDTO;
import org.application.model.dtos.IngredientCreateDTO;
import org.application.model.dtos.IngredientSearchDTO;
import org.application.service.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.application.service.IngredientService;

import java.util.*;

@RestController
public class IngredientController {

    private List<IngredientSearchDTO> ingredientList;
    private final IngredientService ingredientService;

    @Autowired
    IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping(path = "/ingredient")
    public ResponseEntity<CustomResponseDTO> createNewIngredient(@RequestBody @Valid IngredientCreateDTO ingredientDTO,
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

        ingredientList = ingredientService.getAllIngredients();
        if(ingredientList.stream().anyMatch(i -> (i.getName()).equals(ingredientDTO.getName()))) {
            customResponseDTO.setResponseObject(null);
            customResponseDTO.setResponseMessage("Ingredientul exista si trebuie actualizat.");
            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
        }

        IngredientSearchDTO ingredientSearchDTO = ingredientService.createIngredient(ingredientDTO);
        customResponseDTO.setResponseObject(ingredientSearchDTO);
        customResponseDTO.setResponseMessage("Ingredient creat cu succes.");
        return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping(path = "/ingredients")
    public List<IngredientSearchDTO> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

//    @PutMapping(path = "/ingredient/{name}")
//    public ResponseEntity<CustomResponseDTO> updateIngredient(@PathVariable String name,
//                                                              @RequestBody @Valid IngredientDTO ingredientDTO,
//                                                              BindingResult bindingResult) {
//        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
//
//        if (bindingResult.hasErrors()) {
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//
//            StringBuilder errorMessages = new StringBuilder();
//            for (FieldError errorMessage : fieldErrors) {
//                errorMessages.append(errorMessage.getDefaultMessage()).append(" ");
//            }
//
//            customResponseDTO.setResponseObject(null);
//            customResponseDTO.setResponseMessage(String.valueOf(errorMessages));
//            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
//        }
//
//        if(ingredientDTOList.containsKey(name) && Objects.equals(ingredientDTO.getName(), name)) {
//            ingredientService.updateIngredient(ingredientDTO);
//            customResponseDTO.setResponseObject(ingredientDTO);
//            ingredientDTOList.put(ingredientDTO.getName(), ingredientDTO.getQuantity());
//            customResponseDTO.setResponseMessage("Ingredient actualizat cu succes.");
//            return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
//        } else if (!Objects.equals(ingredientDTO.getName(), name)){
//            customResponseDTO.setResponseObject(null);
//            customResponseDTO.setResponseMessage("Numele ingredientului din endpoint trebuie sa coincida cu cel din " +
//                "body.");
//            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
//        } else {
//            customResponseDTO.setResponseObject(null);
//            customResponseDTO.setResponseMessage("Ingredientul nu exista in baza de date.");
//            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
//        }
//    }

//    @DeleteMapping(path = "/ingredient/{name}")
//    public ResponseEntity<CustomResponseDTO> deleteIngredient(@PathVariable String name) {
//
//        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
//
//        if(ingredientDTOList.containsKey(name)) {
//            ingredientService.deleteIngredient(name);
//            ingredientDTOList.remove(name);
//            customResponseDTO.setResponseObject(null);
//            customResponseDTO.setResponseMessage("Ingredientul a fost sters.");
//            return new ResponseEntity<>(customResponseDTO, HttpStatus.OK);
//        } else {
//            customResponseDTO.setResponseObject(null);
//            customResponseDTO.setResponseMessage("Ingredientul nu exista.");
//            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
//        }
//
//    }
}
