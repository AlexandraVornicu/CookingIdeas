package model.dtos;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IngredientDTO {

    @NotBlank(message = "Ingredientul trebuie sa aiba un nume.")
    private String name;
    @NegativeOrZero(message = "Cantitatea ingredientului trebuie sa fie mai mare decat 0.")
    private int quantity;
}
