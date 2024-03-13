package com.eazybytes.accounts;

import com.eazybytes.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = AccountsContactInfoDto.class)
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "Contains full description of all the api endpoints, dto's," +
						" data-structures and their return types and values for Eazybank's accounts microservice rest api",
				version = "v1",
				contact = @Contact(
						name = "David Ngumbu Kamura",
						email = "davidngumbu115@gmail.com"
				),
				license = @License(
						name = "Proprietary",
						url = "https://en.wikipedia.org/wiki/Proprietary_software"
				)
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
