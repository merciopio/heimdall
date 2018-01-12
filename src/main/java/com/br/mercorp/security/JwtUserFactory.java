package com.br.mercorp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Role;
import com.br.mercorp.entity.User;
import com.br.mercorp.security.service.ApplicationService;
import com.br.mercorp.security.service.AuthorizationService;

public class JwtUserFactory {

	@Value("$app.acronym}")
	private String acronym;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	/**
	 * Converte e gera um JwtUser com base nos dados do usuário.
	 *
	 * @param user
	 * @return JwtUser
	 */
	public JwtUser build(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(),
				mapToGrantedAuthorities(user));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 *
	 * @param perfilEnum
	 * @return List<GrantedAuthority>
	 */
	private List<GrantedAuthority> mapToGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Application application = applicationService.findByAcronym(this.acronym).get();
		List<Role> roles = authorizationService.getRoles(application, user);
		roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase())));
		return authorities;
	}

}
