package com.br.mercorp.security.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Role;
import com.br.mercorp.entity.User;
import com.br.mercorp.security.repository.AuthorizationRepository;
import com.br.mercorp.security.service.AuthorizationService;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);
	
	@Autowired
	private AuthorizationRepository authorizationRepository;

	@Override
	public List<Role> getRoles(Application application, User user) {
		log.info("Busca papeis do usuário na aplicação");
		return authorizationRepository.getRoles(application, user);
	}
	
}
