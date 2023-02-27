package io.github.mykeleony.domain.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "order_item")
public class OrderItem {

    private Long id;

    private Order order;

    private Product product;

    private Integer quantity;

}
