package com.br.mercorp.security.service.impl;

import java.util.Optional;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.Application;
import com.br.mercorp.security.repository.ApplicationRepository;
import com.br.mercorp.security.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    
	private static final Logger log = LoggerFactory.getLogger(ApplicationServiceImpl.class);
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Override
	public Optional<Application> findByName(String name) {
		log.info("Buscando applicação por nome");
		return Optional.ofNullable(this.applicationRepository.findByName(name));
	}

	@Override
	public Optional<Application> findByAcronym(String acronym) {
		log.info("Buscando applicação por sigla");
		return Optional.ofNullable(this.applicationRepository.findByAcronym(acronym));
	}

	
}
