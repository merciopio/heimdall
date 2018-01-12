package com.br.mercorp.security.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.br.mercorp.security.JwtUserFactory;
import com.br.mercorp.security.service.UserService;
import com.br.mercorp.entity.User;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String key) throws UsernameNotFoundException {
		Optional<User> user = userService.findByLoginOrEmail(key, key);
		if (user.isPresent()) {
			JwtUserFactory jwtUserFactory = new JwtUserFactory();
			return jwtUserFactory.build(user.get());
		}
		throw new UsernameNotFoundException("Usuário não encontrado.");
	}

}
