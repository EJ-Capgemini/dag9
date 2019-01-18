package com.capgemini.dag9.controller;

import com.capgemini.dag9.model.Order;
import com.capgemini.dag9.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void addCar(@RequestBody Order order) {
        orderService.save(order);
    }
}
