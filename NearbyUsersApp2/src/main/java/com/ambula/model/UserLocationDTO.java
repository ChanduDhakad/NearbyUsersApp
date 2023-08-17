package com.ambula.model;

import javax.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLocationDTO {

	@NotBlank(message = "Name is required")
	private String name;

	@NotNull(message = "Latitude is required")
	@DecimalMin(value = "-90.0", message = "Latitude must be at least -90.0")
	@DecimalMax(value = "90.0", message = "Latitude must be at most 90.0")
	private Double latitude;

	@NotNull(message = "Longitude is required")
	@DecimalMin(value = "-180.0", message = "Longitude must be at least -180.0")
	@DecimalMax(value = "180.0", message = "Longitude must be at most 180.0")
	private Double longitude;

	private boolean excluded;
}
