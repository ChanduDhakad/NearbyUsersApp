package com.ambula.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

	@Column(unique = true)
	@Email(message = "Invalid email")
	private String email;

	private String password;

}
