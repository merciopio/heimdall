package com.br.mercorp.security.repository.custom;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AuthorizationCustomRepository {

}
