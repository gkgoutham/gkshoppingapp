package com.gk.app.shopping.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.gk.app.shopping"})
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
