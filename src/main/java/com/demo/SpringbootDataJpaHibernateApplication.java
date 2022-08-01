package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDataJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaHibernateApplication.class, args);
	}
	
	/*
	 * What is persistence data?
	 * Persistence data is a data that can live outside application(once the application off, the data
	 * would not lost -> out-memory)
	 * 
	 * When talking about persistence data in Java, it means about saving data into database using SQL
	 * 
	 * JPA(Java Persistence API) is specification that define
	 * an API that manages persistence object and object-relational mapping
	 * Hibernate is the implementation of JPA.
	 * 
	 * Data source is a connection that connect our service to database
	 * It will connect through JDBC Driver
	 * JDBC is a Java capabilities to connect to RDBMS(MySQL, PostgreSQL, etc.)
	 * But it only provide the abstraction of the Database
	 * To get the implementation of the database, we could use JDBC Driver to get not the abstraction
	 * but the implementation
	 *  
	 */
}
