package com.demo.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity // Tell hibernate that this class is a Entity(Table)
@Data
@Table(name = "Message")
public class Message {
	/*
	 * Every entity class must have an Id
	 */
	@Id
	/*
	 * GeneratedValue tells Hibernate that this column is auto-increment
	 * There are several strategies to GeneratedValue
	 * 1. Auto -> Hibernate ask SQL which of 3 strategy is the best one for the current situation
	 * 2. Identity -> Hibernate generate a special key in that tabel that is auto-increment
	 * 3. Sequence -> Hibernate generate a Sequence(sequence name is HIBERNATE_SEQUENCE) in our database. 
	 * 				  Every INSERT will update the sequence
	 * 4. Table -> Hibernate generate an extra table that holds our numeric primary key.
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "message_id")
	private Long messageId;
	
	@ColumnDefault("Tidak ada konten") // Default value
	@Column(name = "konten")
	private String content;
	
	@CreationTimestamp // Tell hibernate that once this entity is created, createdAt will updated
	@Temporal(TemporalType.DATE) // Tell to hibernate to save the createdAt to database on DATE type
	private Date createdAt;
	
	@UpdateTimestamp // Tell hibernate that once this entity is updated, updatedAt will updated
	private LocalDate updatedAt;
	
	/*
	 * If we don't specify @Enumerated, then status will be keep by its ordinal
	 * (The default is @Enumerated(EnumType.ORDINAL))
	 */
	@Enumerated(EnumType.STRING)
	private Status status;
}

enum Status{
	OK, PENDING, CANCEL;
}
