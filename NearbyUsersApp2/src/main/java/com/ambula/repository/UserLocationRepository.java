package com.ambula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ambula.model.UserLocation;

import org.springframework.data.domain.Pageable;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Integer> {

	// List<UserLocation> findByExcludedFalseOrderByDistanceAsc(Pageable pageable);

	UserLocation findByName(String name);
}