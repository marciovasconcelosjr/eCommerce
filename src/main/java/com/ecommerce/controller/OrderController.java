package com.ecommerce.controller;

import com.ecommerce.model.OrderModel;
import com.ecommerce.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderModel>> listAll() {
        return ResponseEntity.ok(orderService.listAll());
    }

    @GetMapping("/id")
    public ResponseEntity<OrderModel> findById(@RequestParam String orderId) {
        OrderModel order = orderService.findById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<OrderModel> register(@RequestBody OrderModel orderModel) {
        return ResponseEntity.ok(orderService.registerOrder(orderModel));
    }
}
