package com.eazybutes.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity // open security in application
public class EazyBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankApplication.class, args);
	}

}
