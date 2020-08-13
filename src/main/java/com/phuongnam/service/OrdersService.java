package com.phuongnam.service;

import com.phuongnam.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {
    List<Orders> findAll();
    Orders findById(Long id);
    void save(Orders orders);
    void remove(Long id);
}
