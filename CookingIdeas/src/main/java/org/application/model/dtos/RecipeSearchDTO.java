package org.application.model.dtos;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RecipeSearchDTO {

    private Long id;
    private String name;
    private List<IngredientRecipeSearchDTO> ingredientsList;
    private String[] steps;
    private int duration;
}
