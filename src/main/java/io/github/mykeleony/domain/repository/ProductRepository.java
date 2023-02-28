package io.github.mykeleony.domain.repository;

import io.github.mykeleony.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
