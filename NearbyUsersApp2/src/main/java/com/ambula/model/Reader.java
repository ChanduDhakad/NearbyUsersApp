package com.ambula.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ReaderId;

	@Size(min = 2, max = 10, message = "FirstName should have 2 to 10 characters")
	private String readerName;

	@Email(message = "Invalid email")
	@Column(unique = true)
	private String email;

	private String password;

}
