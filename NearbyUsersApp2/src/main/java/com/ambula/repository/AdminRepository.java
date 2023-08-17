package com.ambula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambula.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmailAndPassword(String userName, String password);

	Admin findByEmail(String email);
}
