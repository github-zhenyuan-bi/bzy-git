package com.supwisdom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SupwsidomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupwsidomApplication.class, args);
	}

}
