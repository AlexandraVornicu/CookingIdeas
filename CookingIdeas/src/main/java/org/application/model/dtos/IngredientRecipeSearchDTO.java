package org.application.model.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class IngredientRecipeSearchDTO {
    private String name;
    private int quantity;
}
