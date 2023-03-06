package io.github.mykeleony.domain.service;

import io.github.mykeleony.domain.model.Customer;
import io.github.mykeleony.domain.model.Product;
import io.github.mykeleony.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public ResponseEntity<Product> get(Long id) {
        return productRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Product> findFiltered(Product product) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Product> example = Example.of(product, exampleMatcher);

        return productRepository.findAll(example);
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
