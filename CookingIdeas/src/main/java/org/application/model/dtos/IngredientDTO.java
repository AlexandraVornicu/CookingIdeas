package org.application.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IngredientDTO {

    @NotBlank(message = "Ingredientul trebuie sa aiba un nume.")
    private String name;
    @Positive(message = "Cantitatea ingredientului trebuie sa fie mai mare decat 0.")
    private int quantity;
}
