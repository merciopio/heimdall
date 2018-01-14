package com.br.mercorp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.Application;
import com.br.mercorp.security.repository.custom.BaseApplicationCustomRepository;

@Repository
@Transactional(readOnly = true)
public interface BaseApplicationRepository extends JpaRepository<Application, Long>, BaseApplicationCustomRepository{ 

    Application findByName(String name);
	
	Application findByAcronym(String acronym);

	
}
