package com.br.mercorp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.mercorp.enums.Restriction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "RESOURCE", schema = "HEIMDALL")
public class Resource extends BaseEntity implements Serializable  {
	
	private static final long serialVersionUID = -3687496525302473753L;

	@Column(name = "NAME")
    private String name;

	@Column(name = "DESCRIPTION")
    private String description;
	
    @Enumerated(EnumType.STRING)
	@Column(name = "RESTRICTION")
    private Restriction restriction;
    
    @ManyToOne
    @JoinColumn(name = "ID_ROLE")
    private Role role; 

}
