package org.codewithsoly.shopservice.controller;

import org.codewithsoly.shopservice.model.Order;
import org.codewithsoly.shopservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("make/{userId}")
    public ResponseEntity<Order> placeOrder(@PathVariable("userId") Integer userId) {
        return orderService.placeOrder(userId);
    }
    @GetMapping("{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable("userId") Integer userId) {
        return orderService.getUserOrders(userId);
    }

}
