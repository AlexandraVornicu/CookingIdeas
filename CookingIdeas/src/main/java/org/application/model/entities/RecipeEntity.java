package org.application.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeEntity {
    private String name;
    private Map<String, Integer> ingredientsAndQuantity;
    private String[] steps;
    private int duration;

}
