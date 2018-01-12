package com.br.mercorp.heimdall.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.mercorp.entity.Application;
import com.br.mercorp.heimdall.repository.custom.ApplicationCustomRepository;

public class ApplicationRepositoryImpl implements ApplicationCustomRepository{
    
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Application> listByName(String name) {
		StringBuffer jpql = new StringBuffer("select a from Application where a.name like :name");
		try {
			Query query = entityManager.createNativeQuery(jpql.toString(), Application.class);
	        query.setParameter("name",  "%" + name + "%");
	        return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Application> listByAcronym(String acronym) {
		StringBuffer jpql = new StringBuffer("select a from Application where a.acronym like :acronym");
		try {
			Query query = entityManager.createNativeQuery(jpql.toString(), Application.class);
	        query.setParameter("acronym",  "%" + acronym + "%");
	        return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
