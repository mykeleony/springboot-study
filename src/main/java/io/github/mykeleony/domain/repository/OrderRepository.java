package io.github.mykeleony.domain.repository;

import io.github.mykeleony.domain.model.Customer;
import io.github.mykeleony.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Set<Order> findByCustomer(Customer customer);

}
