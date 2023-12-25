package com.anantraj.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}


/*

Use only when you need a basic CRUD application. Not suitable for custom configurations

For Spring Data REST, you only need 3 things
1. Entity: Employee
2. JpaRepository: Employee Repository extends JpaRepository
3. Maven POM dependency

That's it. It will do everything for you. No rest controller or service implementation required
 GET: http://localhost:8080/magic-api/employees (can change in properties file)
 */
