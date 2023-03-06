package io.github.mykeleony.domain.service;

import io.github.mykeleony.domain.model.Customer;
import io.github.mykeleony.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> findByName(String name) {
        return customerRepository.findCustomersByNameLike(name);
    }

    public ResponseEntity<Customer> findById(Long id) {
        return customerRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Customer> findFiltered(Customer customerFilter) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Customer> example = Example.of(customerFilter, matcher);

        return customerRepository.findAll(example);
    }

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

//    public List<Customer> searchCustomers2(String name) {
//        return customerRepository.findByNameLike2(name);
//    }

}
