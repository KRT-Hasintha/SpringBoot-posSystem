package org.example.posbackend.controller;

import jakarta.validation.Valid;
import org.example.posbackend.dto.OrderDto;
import org.example.posbackend.service.OrderService;
import org.example.posbackend.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> placeOrder(@RequestBody @Valid OrderDto orderDto) {
        orderService.placeOrder(orderDto);
        return new ResponseEntity<>(new APIResponse<>(201,"Order Placed Successfully", null), HttpStatus.CREATED);
    }
}
