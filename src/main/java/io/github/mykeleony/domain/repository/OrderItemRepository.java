package io.github.mykeleony.domain.repository;

import io.github.mykeleony.domain.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
