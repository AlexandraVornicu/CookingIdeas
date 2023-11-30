package org.application.controller;

import org.application.model.entities.RecipeEntity;
import org.application.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

//    @GetMapping(path = "/recipes")
//    public List<RecipeEntity> getAllRecipes() {
//        return recipeService.getAllRecipes();
//    }
}
