package com.br.mercorp.security.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Role;
import com.br.mercorp.entity.User;
import com.br.mercorp.security.repository.BaseAuthorizationRepository;
import com.br.mercorp.security.service.BaseAuthorizationService;

@Service
public class BaseAuthorizationServiceImpl implements BaseAuthorizationService {

    private static final Logger log = LoggerFactory.getLogger(BaseAuthorizationServiceImpl.class);
	
	@Autowired
	private BaseAuthorizationRepository baseAuthorizationRepository;

	@Override
	public List<Role> getRoles(Application application, User user) {
		log.info("Busca papeis do usuário na aplicação");
		return baseAuthorizationRepository.getRoles(application, user);
	}
	
}
