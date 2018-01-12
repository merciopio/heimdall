package com.br.mercorp.heimdall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Resource;
import com.br.mercorp.entity.Role;

public interface RoleService {
	
	Optional<Role> findOne(long id);
	
    List<Role> listByApplication(Application application);

	Optional<Role> save(Role role);

	void delete(long id);
    
}
