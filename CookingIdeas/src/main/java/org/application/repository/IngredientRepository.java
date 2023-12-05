package org.application.repository;

import org.application.model.entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    @Query(value = "SELECT * FROM ingredients i WHERE i.name = :name AND i.quantity = :quantity", nativeQuery = true)
    List<IngredientEntity> findByNameAndQuantity(@Param("name") String name, @Param("quantity") int quantity);

}
