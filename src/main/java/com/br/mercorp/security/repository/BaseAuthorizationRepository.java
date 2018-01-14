package com.br.mercorp.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Authorization;
import com.br.mercorp.entity.Role;
import com.br.mercorp.entity.User;
import com.br.mercorp.security.repository.custom.BaseAuthorizationCustomRepository;

@Repository
@Transactional(readOnly = true)
public interface BaseAuthorizationRepository extends JpaRepository<Authorization, Long>, BaseAuthorizationCustomRepository{

	@Query("select a.role from Authorization a where a.role.application = :application and a.user = :user)")
    List<Role> getRoles(@Param("application") Application application, @Param("user") User user);
	
}
