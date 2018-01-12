package com.br.mercorp.heimdall.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.br.mercorp.entity.User;
import com.br.mercorp.heimdall.repository.UserRepository;
import com.br.mercorp.heimdall.service.UserService;
import com.br.mercorp.security.util.SenhaUtil;

@Service
public class UserServiceImpl implements UserService {
    
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findByLogin(String login) {
		log.info("Buscando usuário por login");
		return Optional.ofNullable(this.userRepository.findByLogin(login));
	}

	@Override
	public  Optional<User> findByEmail(String email) {
		log.info("Buscando usuário por e-mail");
		return Optional.ofNullable(this.userRepository.findByEmail(email));
	}

	@Override
	public Optional<User> findByName(String name) {
		log.info("Buscando usuário por nome");
		return Optional.ofNullable(this.userRepository.findByName(name));
	}

	@Override
	public Optional<User> findByLoginOrEmail(String login, String email) {
		log.info("Buscando usuário por login ou e-mail");
		return Optional.ofNullable(this.userRepository.findByLoginOrEmail(login, email));
	}
	
	@Override
	public Optional<User> findOne(long id){
		log.info("Buscando usuário pelo id");
		return Optional.ofNullable(this.userRepository.findOne(id));
	}
	
	@Override
	public List<User> findAll(){
		log.info("Buscando lista de usuários ordenada pelo nome");
		return this.userRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
	}
	
	@Override
	public Optional<User> save(User user){
		log.info("Gravando usuário");
		user.setPassword(SenhaUtil.criptografa(user.getPassword()));
		return  Optional.ofNullable(this.userRepository.saveAndFlush(user));
	}
	
	@Override
	public void delete(long id) {
		log.info("Apagando usuário");
		this.userRepository.delete(id);
	}

	@Override
	public long count() {
		log.info("Contando o número de registros de usuário");
		return this.userRepository.count();
	}

}
