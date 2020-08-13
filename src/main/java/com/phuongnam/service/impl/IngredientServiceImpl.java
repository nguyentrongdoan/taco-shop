package com.phuongnam.service.impl;

import com.phuongnam.model.Ingredient;
import com.phuongnam.repository.IngredientRepository;
import com.phuongnam.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
    @Override
    public void remove(Long id) {
        ingredientRepository.deleteById(id);
    }
}
