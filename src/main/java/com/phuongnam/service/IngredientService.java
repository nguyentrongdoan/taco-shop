package com.phuongnam.service;

import com.phuongnam.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IngredientService {
    List<Ingredient> findAll();
    Ingredient findById(Long id);
    void save(Ingredient ingredient);
    void remove(Long id);
}
