package com.ambula.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ReaderDTO {

	
	
	@Size(min = 2, max = 10, message = "FirstName should have 2 to 10 characters")
	private String readerName;
	

	
	@Email(message = "Invalid email")
	@Column(unique = true)
	private String email;
	
	private String password;
	
	
	

}
