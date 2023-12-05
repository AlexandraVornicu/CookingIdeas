package org.application.repository;

import org.application.model.entities.IngredientRecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRecipeRepository extends JpaRepository<IngredientRecipeEntity, Long> {

}
