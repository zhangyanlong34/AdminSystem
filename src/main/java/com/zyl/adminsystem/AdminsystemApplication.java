package com.zyl.adminsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AdminsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminsystemApplication.class, args);
	}
}
