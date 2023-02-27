package io.github.mykeleony.studyonly;


import io.github.mykeleony.studyonly.annotation.Development;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Development
public class ConfigurationExample {

    @Bean
    public CommandLineRunner execute() {
        return args -> {
            System.out.println("Running development configuration!");
        };
    }

}
