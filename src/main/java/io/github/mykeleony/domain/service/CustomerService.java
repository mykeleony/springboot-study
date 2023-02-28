package io.github.mykeleony.domain.service;

import io.github.mykeleony.domain.model.Customer;
import io.github.mykeleony.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> searchCustomers(String name) {
        return customerRepository.findByNameLike(name);
    }

    public List<Customer> searchCustomers2(String name) {
        return customerRepository.findByNameLike2(name);
    }

}
