package com.br.mercorp.heimdall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.mercorp.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	List<Application> findByName(String name);
	
	List<Application> findByAcronym(String acronym);
	
}
