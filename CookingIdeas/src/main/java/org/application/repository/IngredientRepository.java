package org.application.repository;

import org.application.model.entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

}
