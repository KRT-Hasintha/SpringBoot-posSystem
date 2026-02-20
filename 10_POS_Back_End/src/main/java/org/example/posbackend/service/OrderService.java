package org.example.posbackend.service;

import org.example.posbackend.dto.OrderDto;

public interface OrderService {
    void placeOrder(OrderDto orderDto);
}
