package repository;

import model.dtos.IngredientDTO;
import model.entities.IngredientEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {

    private IngredientDTO ingredientDTO1 = new IngredientDTO("mar", 2);
    private IngredientDTO ingredientDTO2 = new IngredientDTO("faina", 1);

    private List<IngredientEntity> ingredientEntities = new ArrayList<>();

    public IngredientEntity createIngredient(IngredientEntity ingredientToSave) {
        ingredientEntities.add(ingredientToSave);
        return ingredientToSave;
    }
}
