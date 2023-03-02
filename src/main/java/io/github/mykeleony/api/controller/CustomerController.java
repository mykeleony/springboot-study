package io.github.mykeleony.api.controller;

import io.github.mykeleony.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/sales")
public class CustomerController {

    private CustomerService customerService;

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
