package com.br.mercorp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Mércio Carvalho
 *
 */
/**
 * @author Mércio
 *
 */
public class SenhaUtil {

	/**
	 * Gera um hash utilizando o Bcrypt
	 * 
	 * @param senha uma sequência de caracteres para ser criptografada
	 * @return um hash gerado a partir da senha
	 * @see BCryptPasswordEncoder
	 */
	public static String criptografa(String senha) {
		return senha == null ? senha : new BCryptPasswordEncoder().encode(senha);		
	}
	
	/**
	 * Verifica a validade da senha
	 * 
	 * @param senha  uma sequência de caracteres
	 * @param codificacao hash de compatibilidade
	 * @return a avaliação da compatibilidade do hash com a senha
	 */
	public static boolean valida(String senha, String codificacao) {
		return new BCryptPasswordEncoder().matches(senha, codificacao);
	}
	
}
