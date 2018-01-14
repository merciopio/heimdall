package com.br.mercorp.heimdall.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.Authorization;
import com.br.mercorp.heimdall.repository.AuthorizationRepository;
import com.br.mercorp.heimdall.service.AuthorizationService;

@Service
@Qualifier("heimdallAuthorizationServiceImpl")
public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);
	
	@Autowired
	private AuthorizationRepository authorizationRepository;

	@Override
	public Optional<Authorization> save(Authorization authorization) {
		log.info("Gravando autorização");
		return Optional.ofNullable(this.authorizationRepository.saveAndFlush(authorization));
	}
	
}
