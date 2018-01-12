package com.br.mercorp.security.service.impl;

import java.util.Optional;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.User;
import com.br.mercorp.security.repository.UserRepository;
import com.br.mercorp.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findByLogin(String login) {
		log.info("Buscando usuário por login");
		return Optional.ofNullable(this.userRepository.findByLogin(login));
	}

	@Override
	public  Optional<User> findByEmail(String email) {
		log.info("Buscando usuário por e-mail");
		return Optional.ofNullable(this.userRepository.findByEmail(email));
	}

	@Override
	public Optional<User> findByName(String name) {
		log.info("Buscando usuário por nome");
		return Optional.ofNullable(this.userRepository.findByName(name));
	}

	@Override
	public Optional<User> findByLoginOrEmail(String login, String email) {
		log.info("Buscando usuário por login ou e-mail");
		return Optional.ofNullable(this.userRepository.findByLoginOrEmail(login, email));
	}
	
}
