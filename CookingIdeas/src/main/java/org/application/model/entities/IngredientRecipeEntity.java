package org.application.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class IngredientRecipeEntity {
    @Id
    private String name;
    private int quantity;
    @ManyToMany
    private List<RecipeEntity> recipes;
}
