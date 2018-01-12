package com.br.mercorp.heimdall.service;

import java.util.List;
import java.util.Optional;

import com.br.mercorp.entity.User;

public interface UserService extends com.br.mercorp.security.service.UserService {

	Optional<User> findOne(long id);

	List<User> findAll();

	Optional<User> save(User user);

	void delete(long id);

	long count();
	
}
