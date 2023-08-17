package com.ambula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class UserLocation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userLocationId;

	
    @NotBlank(message = "Name is required")
	@Column(unique = true)
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

