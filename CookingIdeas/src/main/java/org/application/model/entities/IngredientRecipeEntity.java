package org.application.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "ingredientRecipe")
@Table(name = "ingredientRecipes")
public class IngredientRecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    @ManyToMany
    @JoinTable(name = "recipes_ingredients",
        joinColumns = @JoinColumn(name = "recipeEntity_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredientRecipeEntity_id"))
    private List<RecipeEntity> recipes;
}
