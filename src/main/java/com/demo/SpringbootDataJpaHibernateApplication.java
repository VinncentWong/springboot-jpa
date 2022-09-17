package com.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Email;
import com.demo.entities.Message2;
import com.demo.repository.EmailRepository;
import com.demo.repository.Message2Repository;
import com.demo.repository.MessageRepository;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class SpringbootDataJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaHibernateApplication.class, args);
	}
	
	/*
	 * What is persistence data?
	 * Persistence data is a data that can live outside application(once the application off, the data
	 * would not lost -> out-memory) and stored in database
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
	 * In easy way, we can use data source configuration on application.properties with prefix
	 * spring.data.source.<configuration> = <value>
	 * 
	 * Or you can make a Bean of a DataSource -> the famous data source that used in Java is
	 * Hikari-Pool
	 * 
	 * JDBC Driver is not only the way to connect to Database, we can connect to database through 
	 * Hibernate -> Hibernate also provide the implementation of the database
	 */
}

@RestController
class ControllerCustom{

	@Autowired
	private Coba coba;
	
	@GetMapping("/callone")
	public void callOne() {
		this.coba.callOne();
	}
	
	@GetMapping("/calltwo")
	public void callTwo() {
		this.coba.callTwo();
	}
	
	@GetMapping("/getmessage/{emailId}")
	public Message2 getEmail(@PathVariable("emailId") Long id) {
		return this.coba.getMessage(id);
	}
}

@Component
class Coba{
	
	@Autowired
	private Message2Repository repository;
	
	@Autowired
	private EmailRepository emailRepo;
	
	public void callOne() {
		Message2 message2 = new Message2();
		Email email = new Email();
		message2.setContent("content1");
		email.setSubject("centcentcent");
		message2.setEmail(email);
		this.repository.save(message2);
	}
	
	public void callTwo() {
		Email email = new Email();
		email.setSubject("subject");
		Message2 message = new Message2();
		message.setContent("centwong");
		message.setEmail(email);
		email.setMessage(message);
		this.emailRepo.save(email);
	}
	
	public Message2 getMessage(Long messageId) {
		return this.repository.findById(messageId).get();
	}
}

@Configuration
class Config{
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource hikari = new HikariDataSource();
		hikari.setJdbcUrl("jdbc:mysql://localhost:3306/hibernate");
		hikari.setUsername("root");
		hikari.setPassword("");
		hikari.setConnectionTimeout(3000);
		return hikari;
	}
}