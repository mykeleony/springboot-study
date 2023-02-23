package io.github.mykeleony;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationExample {

    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sales application";
    }

}
