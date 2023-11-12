package org.application.service;

import org.application.model.dtos.IngredientDTO;
import org.application.model.entities.IngredientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.application.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    @Autowired
    IngredientService(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    public IngredientDTO createIngredient(IngredientDTO ingredientToCreateDTO) {

        IngredientEntity ingredientEntity = ingredientMapper.mapIngredientDTOtoIngredientEntity(ingredientToCreateDTO);
        IngredientEntity createdIngredientEntity = ingredientRepository.createIngredient(ingredientEntity);

        return ingredientMapper.mapIngredientEntityToIngredientDTO(createdIngredientEntity);
    }

    public List<IngredientDTO> getAllIngredients() {
        List<IngredientDTO> ingredientDTOList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ingredientRepository.getAllIngredients().entrySet()) {
            IngredientEntity ingredientEntity = new IngredientEntity();
            ingredientEntity.setName(entry.getKey());
            ingredientEntity.setQuantity(entry.getValue());
            ingredientDTOList.add(ingredientMapper.mapIngredientEntityToIngredientDTO(ingredientEntity));
        }
        return ingredientDTOList;
    }

    public IngredientDTO updateIngredient(IngredientDTO ingredientToCreateDTO) {

        IngredientEntity ingredientEntity = ingredientMapper.mapIngredientDTOtoIngredientEntity(ingredientToCreateDTO);
        IngredientEntity createdIngredientEntity = ingredientRepository.updateIngredient(ingredientEntity);

        return ingredientMapper.mapIngredientEntityToIngredientDTO(createdIngredientEntity);
    }
}
