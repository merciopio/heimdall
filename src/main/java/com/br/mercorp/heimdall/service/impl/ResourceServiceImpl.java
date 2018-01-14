package com.br.mercorp.heimdall.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Resource;
import com.br.mercorp.heimdall.repository.ResourceRepository;
import com.br.mercorp.heimdall.service.ResourceService;

@Service
@Qualifier("heimdallResourceServiceImpl")
public class ResourceServiceImpl implements ResourceService {

    private static final Logger log = LoggerFactory.getLogger(ResourceServiceImpl.class);
	
	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public Optional<Resource> findOne(long id) {
		log.info("Buscando papel por id");
		return Optional.ofNullable(this.resourceRepository.findOne(id));
	}

	@Override
	public List<Resource> listByApplication(Application application) {
		log.info("Buscando recurso por aplicação");
		return this.resourceRepository.listByApplication(application);
	}

	@Override
	public Optional<Resource> save(Resource resource) {
		log.info("Gravando recurso");
		return Optional.ofNullable(this.resourceRepository.saveAndFlush(resource));
	}

	@Override
	public void delete(long id) {
		log.info("Apagando recurso");
		this.resourceRepository.delete(id);
	}

}
