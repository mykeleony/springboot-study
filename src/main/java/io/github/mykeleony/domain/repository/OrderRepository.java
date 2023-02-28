package io.github.mykeleony.domain.repository;

import io.github.mykeleony.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
