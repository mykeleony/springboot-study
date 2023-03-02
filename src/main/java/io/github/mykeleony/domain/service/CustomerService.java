package io.github.mykeleony.domain.service;

import io.github.mykeleony.domain.model.Customer;
import io.github.mykeleony.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
