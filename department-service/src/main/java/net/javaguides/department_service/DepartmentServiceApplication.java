package net.javaguides.department_service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Department Service REST APIs",
                description = "Department Service REST API Documentation",
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
                description = "Department Service Doc",
                url = "https://www.javaguides.net"
        )
)
public class DepartmentServiceApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

}
