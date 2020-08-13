package com.phuongnam.service;


import com.phuongnam.model.Taco;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TacoService {
    List<Taco> findAll();
    Taco findById(Long id);
    void save(Taco taco);
    void remove(Long id);
}
