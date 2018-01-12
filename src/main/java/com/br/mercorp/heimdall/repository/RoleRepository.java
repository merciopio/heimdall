package com.br.mercorp.heimdall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Role;
import com.br.mercorp.heimdall.repository.custom.RoleCustomRepository;

@Repository
@Transactional(readOnly = true)
public interface RoleRepository extends JpaRepository<Role, Long>, RoleCustomRepository{ 
	
	@Query("select r from Role r where r.application = :application)")
	List<Role> listByApplication(@Param("application") Application application);
	
}