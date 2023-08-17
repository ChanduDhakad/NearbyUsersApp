package com.ambula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ambula.model.CurrentUserSession;

@Repository
public interface CurrentUserRepository extends JpaRepository<CurrentUserSession, Integer> {

	CurrentUserSession findByUuid(String uuid);

}
