package io.github.mykeleony.domain.service;

import io.github.mykeleony.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;

}
