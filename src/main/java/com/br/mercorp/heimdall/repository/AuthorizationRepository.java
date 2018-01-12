package com.br.mercorp.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.Authorization;
import com.br.mercorp.heimdall.repository.custom.AuthorizationCustomRepository;

@Repository
@Transactional(readOnly = true)
public interface AuthorizationRepository extends JpaRepository<Authorization, Long>, AuthorizationCustomRepository{

	
}
