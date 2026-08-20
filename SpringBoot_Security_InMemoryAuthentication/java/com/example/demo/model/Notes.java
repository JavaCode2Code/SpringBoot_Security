package com.example.demo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Notes {

	@Id
	@GeneratedValue
	private Long id;
	
	@Lob
	private String content;
	
	private String ownerUsername;
}
