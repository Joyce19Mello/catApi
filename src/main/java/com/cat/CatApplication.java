package com.cat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatApplication.class, args);

	}

}
