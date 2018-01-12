package com.br.mercorp.heimdall.service;

import java.util.Optional;

import com.br.mercorp.entity.Authorization;

public interface AuthorizationService {

	Optional<Authorization> save(Authorization authorization);

}
