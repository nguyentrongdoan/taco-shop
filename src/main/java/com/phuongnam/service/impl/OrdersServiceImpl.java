package com.phuongnam.service.impl;

import com.phuongnam.model.Orders;
import com.phuongnam.repository.OrdersRepository;
import com.phuongnam.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders findById(Long id) {
       return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void remove(Long id) {
        ordersRepository.deleteById(id);
    }
}
