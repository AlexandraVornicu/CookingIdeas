package org.application.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class IngredientSearchDTO {

    private Long id;
    private String name;
    private int quantity;
}
