package com.br.Kodominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KodominioApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodominioApplication.class, args);
		System.out.println("Aplicação ligada com sucesso!");
	}

}
