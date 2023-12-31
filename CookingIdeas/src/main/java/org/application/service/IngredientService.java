package org.application.service;

import org.application.model.dtos.IngredientCreateDTO;
import org.application.model.dtos.IngredientSearchDTO;
import org.application.model.dtos.IngredientUpdateDTO;
import org.application.model.entities.IngredientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.application.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    @Autowired
    IngredientService(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    public IngredientSearchDTO createIngredient(IngredientCreateDTO ingredientToCreateDTO) {

        IngredientEntity ingredientEntity = ingredientMapper.mapIngredientDTOtoIngredientEntity(ingredientToCreateDTO);
        IngredientEntity createdIngredientEntity = ingredientRepository.save(ingredientEntity);
        return ingredientMapper.mapIngredientEntityToIngredientSearchDTO(createdIngredientEntity);
    }

    public List<IngredientSearchDTO> getAllIngredients() {
        List<IngredientSearchDTO> ingredientDTOList = new ArrayList<>();
        for (IngredientEntity ingredientEntity : ingredientRepository.findAll()) {
            ingredientDTOList.add(ingredientMapper.mapIngredientEntityToIngredientSearchDTO(ingredientEntity));
        }
        return ingredientDTOList;
    }

    public List<IngredientSearchDTO> findByNameAndQuantity(String name, int quantity) {
        List<IngredientSearchDTO> ingredientDTOList = new ArrayList<>();
        List<IngredientEntity> ingredientEntityList = ingredientRepository.findByNameAndQuantity(name, quantity);
        for (IngredientEntity ingredientEntity : ingredientEntityList) {
            ingredientDTOList.add(ingredientMapper.mapIngredientEntityToIngredientSearchDTO(ingredientEntity));
        }
        return ingredientDTOList;
    }

    public void updateIngredient(IngredientUpdateDTO ingredientUpdateDTO) {
        IngredientEntity ingredientEntityToUpdate = ingredientRepository
            .findAll().stream().filter(i -> (i.getName()).equals(ingredientUpdateDTO.getName()))
            .findFirst().orElse(null);
        ingredientEntityToUpdate.setQuantity(ingredientUpdateDTO.getQuantity());
        ingredientRepository.save(ingredientEntityToUpdate);
    }

    public void deleteIngredient(String name) {
        IngredientEntity ingredientEntityToDelete =
            ingredientRepository.findAll().stream().filter(i -> (i.getName()).equals(name)).findFirst().orElse(null);
        ingredientRepository.delete(ingredientEntityToDelete);
    }
}
