package org.application.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class IngredientCreateDTO {

    @NotBlank(message = "Ingredientul trebuie sa aiba un nume.")
    private String name;
    @Positive(message = "Cantitatea ingredientului trebuie sa fie mai mare decat 0.")
    private int quantity;
}
