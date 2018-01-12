package com.br.mercorp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.Application;
import com.br.mercorp.heimdall.repository.custom.ApplicationCustomRepository;

@Repository
@Transactional(readOnly = true)
public interface ApplicationRepository extends JpaRepository<Application, Long>, ApplicationCustomRepository{ 

    Application findByName(String name);
	
	Application findByAcronym(String acronym);

	
}
