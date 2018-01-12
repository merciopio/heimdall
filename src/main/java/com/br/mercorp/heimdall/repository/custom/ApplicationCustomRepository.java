package com.br.mercorp.heimdall.repository.custom;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.br.mercorp.entity.Application;

@Transactional(readOnly = true)
public interface ApplicationCustomRepository {
	
	List<Application> listByName(String name);

	List<Application> listByAcronym(String acronym);
	
}
