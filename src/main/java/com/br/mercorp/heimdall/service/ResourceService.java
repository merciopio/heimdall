package com.br.mercorp.heimdall.service;

import java.util.List;
import java.util.Optional;

import com.br.mercorp.entity.Application;
import com.br.mercorp.entity.Resource;

public interface ResourceService {
	
	Optional<Resource> findOne(long id);

	List<Resource> listByApplication(Application application);

	Optional<Resource> save(Resource resource);

	void delete(long id);
}
