package com.br.mercorp.heimdall.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Role;
import com.br.mercorp.heimdall.repository.RoleRepository;
import com.br.mercorp.heimdall.service.RoleService;

@Service
@Qualifier("heimdallRoleServiceImpl")
public class RoleServiceImpl implements RoleService{
	 
	private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
		
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Optional<Role> findOne(long id) {
		log.info("Buscando papel por id");
		return Optional.ofNullable(this.roleRepository.findOne(id));
	}

	@Override
	public Optional<Role> save(Role role) {
		log.info("Gravando papel");
		return Optional.ofNullable(this.roleRepository.saveAndFlush(role));
	}

	@Override
	public void delete(long id){
		log.info("Apagando papel");
		this.roleRepository.delete(id);
	}

	@Override
	public List<Role> listByApplication(Application application) {
		log.info("Buscando papel por aplicação");
		return this.roleRepository.listByApplication(application);
	}
	
}
