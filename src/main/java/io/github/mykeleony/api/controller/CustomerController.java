package io.github.mykeleony.api.controller;

import io.github.mykeleony.domain.model.Customer;
import io.github.mykeleony.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        return customerService.save(customer);
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
