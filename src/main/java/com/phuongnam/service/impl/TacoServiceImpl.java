package com.phuongnam.service.impl;


import com.phuongnam.model.Taco;
import com.phuongnam.repository.TacoRepository;
import com.phuongnam.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacoServiceImpl implements TacoService {
    @Autowired
    private TacoRepository tacoRepository;
    @Override
    public List<Taco> findAll() {
        return tacoRepository.findAll();
    }

    @Override
    public Taco findById(Long id) {
        return tacoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Taco taco) {
        tacoRepository.save(taco);
    }

    @Override
    public void remove(Long id) {
        tacoRepository.deleteById(id);
    }
}
