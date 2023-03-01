package io.github.mykeleony;

import io.github.mykeleony.domain.model.Customer;
import io.github.mykeleony.domain.model.Order;
import io.github.mykeleony.domain.repository.CustomerRepository;
import io.github.mykeleony.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired CustomerRepository customerRepository,
                                  @Autowired OrderRepository orderRepository) {
        return args -> {
            System.out.println("Saving customers");

            Customer c = new Customer();
            c.setName("Myke");

            customerRepository.save(c);

            Order order = new Order();
            order.setCustomer(c);
            order.setOrderDate(LocalDate.now());
            order.setTotal(BigDecimal.valueOf(100.0));

            orderRepository.save(order);

            Customer c1 = customerRepository.findCustomerFetchOrOrders(c.getId());
            System.out.println(c1);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }


}
