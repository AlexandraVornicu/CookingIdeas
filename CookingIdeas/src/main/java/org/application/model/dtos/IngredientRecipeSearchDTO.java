package org.application.model.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class IngredientRecipeSearchDTO {
    private Long id;
    private String name;
    private int quantity;
}
