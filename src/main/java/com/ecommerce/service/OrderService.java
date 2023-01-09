package com.ecommerce.service;

import com.ecommerce.model.CustomerModel;
import com.ecommerce.model.OrderModel;
import com.ecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    public List<OrderModel> listAll() {
        return orderRepository.findAll();
    }

    public OrderModel findById(String id) {
        Optional<OrderModel> orderOpt = orderRepository.findById(id);
        if (orderOpt.isPresent()) {
            return orderOpt.get();
        }
        return null;
    }

    public OrderModel registerOrder(OrderModel orderModel) {
        CustomerModel customer = customerService.findById(orderModel.getCostumerId());
        if(customer == null) {
            throw new RuntimeException("Customer id not exists");
        }
        return orderRepository.save(orderModel);
    }
}
