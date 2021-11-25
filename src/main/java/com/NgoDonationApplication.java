package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class NgoDonationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgoDonationApplication.class, args);
		System.out.println("connection established");
	}

}
