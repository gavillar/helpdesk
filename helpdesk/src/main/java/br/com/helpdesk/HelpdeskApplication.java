package br.com.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HelpdeskApplication {

	public String PORT = System.getenv("PORT");

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}



}
