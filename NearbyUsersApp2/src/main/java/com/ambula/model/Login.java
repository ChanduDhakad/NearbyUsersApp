package com.ambula.model;

import javax.validation.constraints.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Login {

	@Email(message = "Invalid email")
	private String Email;

	@NotBlank(message = "password Should not be Blank")
	private String password;
}
