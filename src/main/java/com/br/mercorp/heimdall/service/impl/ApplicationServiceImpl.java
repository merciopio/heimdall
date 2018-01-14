package com.br.mercorp.heimdall.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.Application;
import com.br.mercorp.heimdall.repository.ApplicationRepository;
import com.br.mercorp.heimdall.service.ApplicationService;

@Service
@Qualifier("heimdallApplicationServiceImpl")
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

	@Override
	public Optional<Application> save(Application application) {
		log.info("Gravando aplicação");
		return Optional.ofNullable(this.applicationRepository.save(application));
	}

	@Override
	public void delete(long id) {
		log.info("Apagando aplicação");
		this.applicationRepository.delete(id);
	}

	@Override
	public Optional<Application> findOne(long id) {
		log.info("Buscando lista de aplicação por id");
		return Optional.ofNullable(this.applicationRepository.findOne(id));
	}

	@Override
	public List<Application> findAll() {
		log.info("Buscando lista de aplicações ordenada pelo nome");
		return this.applicationRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
	}

	
}
