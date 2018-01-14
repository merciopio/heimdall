package com.br.mercorp.security.service.impl;

import java.util.Optional;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.Application;
import com.br.mercorp.security.repository.BaseApplicationRepository;
import com.br.mercorp.security.service.BaseApplicationService;

@Service
public class BaseApplicationServiceImpl implements BaseApplicationService {
    
	private static final Logger log = LoggerFactory.getLogger(BaseApplicationServiceImpl.class);
	
	@Autowired
	private BaseApplicationRepository baseApplicationRepository;
	
	@Override
	public Optional<Application> findByName(String name) {
		log.info("Buscando applicação por nome");
		return Optional.ofNullable(this.baseApplicationRepository.findByName(name));
	}

	@Override
	public Optional<Application> findByAcronym(String acronym) {
		log.info("Buscando applicação por sigla");
		return Optional.ofNullable(this.baseApplicationRepository.findByAcronym(acronym));
	}

	
}
