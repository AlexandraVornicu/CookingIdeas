package org.application.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class RecipeCreateDTO {

    @NotBlank(message = "Reteta trebuie sa aiba un nume.")
    private String name;
    @NotEmpty(message = "Reteta trebuie sa aiba minim 1 ingredient.")
    private List<IngredientRecipeCreateDTO> ingredientsList;
    @NotEmpty(message = "Reteta trebuie sa aiba minim un pas indicat.")
    private String[] steps;
    @Positive(message = "Durata retetei trebuie sa fie mai mare decat 0 minute.")
    private int duration;

}
