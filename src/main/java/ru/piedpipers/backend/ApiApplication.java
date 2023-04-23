package ru.piedpipers.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.piedpipers.backend.security.AppProperties;


@SpringBootApplication()
@EnableConfigurationProperties(AppProperties.class)
public class ApiApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApiApplication.class, args);
    }
}
