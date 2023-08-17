package com.ambula.model;

import javax.persistence.Column;
import javax.validation.constraints.*;

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

	@Pattern(regexp = "[A-Za-z]")
	private String UserName;

	@NotBlank(message = "Password cannot be blank")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,12}$", message = "Password must have at least one uppercase letter, one lowercase letter, and one digit")
	private String password;
}
