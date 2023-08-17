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
	
	@NotEmpty(message = "Password Should not be Empty")
	@NotBlank(message=  "password Should not be Blank")
	@NotNull(message = "Password Should Not be Null")
	private String password;
		
}
