package com.br.mercorp.heimdall.repository.custom;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AuthorizationCustomRepository {

}
