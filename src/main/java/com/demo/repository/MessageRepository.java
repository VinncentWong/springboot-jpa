package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	@Query(value = "SELECT * FROM Message WHERE message_id = ?1", nativeQuery = true) 
	Optional<Message> findMessageByContent(String content);
	
	// For Sorting
//	List<Message> findListMessage(Sort sort);
	
	// For Pagination -> We use interface in the repo, but in the implementation, we use PageRequest class
//	List<Message> findListMessageByPagination(Pageable page);
}
