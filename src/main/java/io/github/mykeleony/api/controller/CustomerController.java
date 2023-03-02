package io.github.mykeleony.api.controller;

import io.github.mykeleony.domain.repository.CustomerRepository;
import io.github.mykeleony.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/sales")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping({"/hello/{name}", "/hey/{name}"})
    public String helloClient(@PathVariable String name) {
        return String.format("Hello, %s! Welcome to Myke's REST API!", name);
    }

}
