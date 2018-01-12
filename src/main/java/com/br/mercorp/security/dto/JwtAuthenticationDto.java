package com.br.mercorp.security.dto;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationDto {

	@NotEmpty ( message = "Login não pode ser vazio." )
	private String login;
	
	@NotEmpty ( message = "Senha não pode ser vazia." )
	private String password;
	
	
}
