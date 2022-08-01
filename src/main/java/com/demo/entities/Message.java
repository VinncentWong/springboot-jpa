package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity // Tell hibernate that this class is a Entity(Table)
@Data
@Table(name = "Message")
public class Message {
	/*
	 * Every entity class must have an Id
	 */
	@Id
	private Long messageId;
	
	private String content;
}
