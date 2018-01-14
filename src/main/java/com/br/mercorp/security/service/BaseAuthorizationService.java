package com.br.mercorp.security.service;

import java.util.List;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Role;
import com.br.mercorp.entity.User;

public interface BaseAuthorizationService {

	List<Role> getRoles(Application application, User user);
	
}
