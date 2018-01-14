package com.br.mercorp.security.service;

import java.util.Optional;

import com.br.mercorp.entity.User;

public interface BaseUserService{

	Optional<User> findByLogin(String login);

	Optional<User> findByEmail(String email);
	
	Optional<User> findByName(String name);
	
	Optional<User> findByLoginOrEmail(String login, String email);

	
}
