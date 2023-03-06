package io.github.mykeleony.api.controller;

import io.github.mykeleony.domain.model.Customer;
import io.github.mykeleony.domain.repository.CustomerRepository;
import io.github.mykeleony.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    private CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping
    public List<Customer> find(Customer customerFilter) {
        return customerService.findFiltered(customerFilter);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        if (!customerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        customer.setId(id);
        Customer updatedCustomer = customerService.save(customer);

        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        if (!customerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        customerService.remove(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping({"/hello/{name}", "/hey/{name}"})
    public String helloCustomer(@PathVariable String name) {
        return String.format("Hello, %s! Welcome to Myke's REST API!", name);
    }

    @RequestMapping(value = "/helloRequest/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloRequestCustomer(@PathVariable String name) {
        return String.format("Hello, %s that is using @RequestMapping! Welcome to Myke's REST API!", name);
    }

}
