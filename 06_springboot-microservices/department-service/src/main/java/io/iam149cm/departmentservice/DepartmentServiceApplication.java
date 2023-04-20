package io.iam149cm.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST APIs Documentation",
				version = "1.0.0",
				contact = @Contact(
						name = "iam149cm",
						email = "iam149cm@email.com",
						url = "https://github.com/iam149cm"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/iam149cm"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department Service External Documentation",
				url = "https://github.com/iam149cm"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
