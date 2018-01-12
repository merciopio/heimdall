package com.br.mercorp.heimdall.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.mercorp.heimdall.repository.custom.UserCustomRepository;

public class UserRepositoryImpl implements UserCustomRepository{
    
	@Autowired
	EntityManager entityManager;
	
}
