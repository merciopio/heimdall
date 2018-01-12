package com.br.mercorp.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.User;
import com.br.mercorp.heimdall.repository.custom.UserCustomRepository;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository, com.br.mercorp.security.repository.UserRepository{ 
	
	
}
