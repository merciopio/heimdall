package com.br.mercorp.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.User;
import com.br.mercorp.security.repository.custom.BaseUserCustomRepository;

@Repository
@Transactional(readOnly = true)
public interface BaseUserRepository extends JpaRepository<User, Long>, BaseUserCustomRepository{ 

	User findByLogin(String login);

	User findByEmail(String email);
	
	User findByName(String name);
	
	User findByLoginOrEmail(String login, String email);
	
	@Query("select u from User u where upper(u.name) like upper(concat('%',:filter,'%')) or upper(u.login) like upper(concat('%',:filter,'%')) or upper(u.email) like upper(concat('%',:filter,'%'))")
    List<User> listByFilter(@Param("filter") String filter);	
	
}
