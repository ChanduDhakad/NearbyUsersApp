package com.ambula.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currentUsers")
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	private LocalDateTime timestamp;
	private String uuid;
}
