package com.br.mercorp.security.service.impl;

import java.util.Optional;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.User;
import com.br.mercorp.security.repository.BaseUserRepository;
import com.br.mercorp.security.service.BaseUserService;

@Service
public class BaseUserServiceImpl implements BaseUserService {
    
	private static final Logger log = LoggerFactory.getLogger(BaseUserServiceImpl.class);
	
	@Autowired
	private BaseUserRepository baseUserRepository;

	@Override
	public Optional<User> findByLogin(String login) {
		log.info("Buscando usuário por login");
		return Optional.ofNullable(this.baseUserRepository.findByLogin(login));
	}

	@Override
	public  Optional<User> findByEmail(String email) {
		log.info("Buscando usuário por e-mail");
		return Optional.ofNullable(this.baseUserRepository.findByEmail(email));
	}

	@Override
	public Optional<User> findByName(String name) {
		log.info("Buscando usuário por nome");
		return Optional.ofNullable(this.baseUserRepository.findByName(name));
	}

	@Override
	public Optional<User> findByLoginOrEmail(String login, String email) {
		log.info("Buscando usuário por login ou e-mail");
		return Optional.ofNullable(this.baseUserRepository.findByLoginOrEmail(login, email));
	}
	
}
