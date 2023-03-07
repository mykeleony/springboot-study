package io.github.mykeleony.api.controller;

import io.github.mykeleony.domain.repository.OrderRepository;
import io.github.mykeleony.domain.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    private OrderRepository orderRepository;

}
