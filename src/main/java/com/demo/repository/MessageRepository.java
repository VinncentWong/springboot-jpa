package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	/*
	 *  We can make query ourself -> 
	 *  This is a good approach due to hard query 
	 *  will make the name of the method more complex
	 *  We can add native query = true if we want the query is follow the SQL syntax
	 */
	@Query("SELECT * FROM Message WHERE Message.messageId = ?1") 
	Optional<Message> findMessageByContent(String content);
}
