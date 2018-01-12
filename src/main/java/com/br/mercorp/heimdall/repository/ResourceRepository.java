package com.br.mercorp.heimdall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Resource;
import com.br.mercorp.entity.Role;
import com.br.mercorp.heimdall.repository.custom.ResourceCustomRepository;

@Repository
@Transactional(readOnly = true)
public interface ResourceRepository extends JpaRepository<Resource, Long>, ResourceCustomRepository{ 
	
	@Query("select r from Resource r where r.role = :role)")
	List<Resource> listByByRole(@Param("role") Role role);
		
	@Query("select r from Resource r where r.role.application = :application)")
    List<Resource> listByApplication(@Param("application") Application application);
	
}