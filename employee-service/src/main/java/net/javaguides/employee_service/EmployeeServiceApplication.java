package net.javaguides.employee_service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Employee Service REST APIs",
                description = "Employee Service REST API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "name",
                        email = "email@gamil.com",
                        url = "https://www.javaguides.net"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.javaguides.net"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Employee Service Doc",
                url = "https://www.javaguides.net"
        )
)
@EnableFeignClients
public class EmployeeServiceApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }


    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
