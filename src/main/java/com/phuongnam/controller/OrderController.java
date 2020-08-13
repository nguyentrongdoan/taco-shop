package com.phuongnam.controller;


import com.phuongnam.model.Orders;
import com.phuongnam.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/current")
    public String showOrderForm(Model model) {
        model.addAttribute("orders", new Orders());
        return "orderForm";
    }

    @PostMapping
    public String saveOrder(Orders orders, Model model) {
        LocalDateTime now = LocalDateTime.now();
        orders.setPlacedAt(now);
        ordersService.save(orders);
        model.addAttribute(orders);
        return "redirect:orders/orders-list";
    }
    @GetMapping("/orders-list")
    public ModelAndView showOrderList(){
        List<Orders> orders = ordersService.findAll();
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Orders orders = ordersService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit-order");
        modelAndView.addObject("order", orders);
        return modelAndView;
    }

    @PutMapping("/edit")
    public ModelAndView editOrder(@ModelAttribute("order") Orders orders) {
        ordersService.save(orders);
        ModelAndView modelAndView = new ModelAndView("edit-order");
        modelAndView.addObject("order", orders);
        modelAndView.addObject("message", "Edit was successful !");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Orders orders = ordersService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete-order");
        modelAndView.addObject("order", orders);
        return modelAndView;

    }

    @PostMapping("/delete")
    public String deleteNote(@ModelAttribute("order") Orders orders) {
        ordersService.remove(orders.getId());
        return "redirect:orders/orders-list";
    }

}

