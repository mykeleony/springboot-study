package io.github.mykeleony;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/sales")
public class SalesApplication {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

    @GetMapping
    public String helloWorld() {
        return applicationName;
    }

}
