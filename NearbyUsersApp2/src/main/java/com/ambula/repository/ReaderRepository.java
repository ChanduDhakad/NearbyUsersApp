package com.ambula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambula.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
	Reader findByEmailAndPassword(String email,String password);
	Reader findByEmail(String email);
}
