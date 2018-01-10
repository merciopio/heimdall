package com.br.mercorp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "APPLICATION", schema = "HEIMDALL")
public class Application extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 660365307268741542L;

	@Column(name = "ACRONYM")
    private String acronym;
    
	@Column(name = "NOME")
    private String name;
    
	@Column(name = "URL")
    private String url;
	
	/*@OneToMany(mappedBy="Application", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Role> roles;*/
		   
}

