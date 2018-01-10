package com.br.mercorp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ROLE", schema = "HEIMDALL")
public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1799251155741990772L;

	@Column(name = "NAME")
    private String name;

	@Column(name = "DESCRIPTION")
    private String description;

	@ManyToOne
    @JoinColumn(name = "ID_APPLICATION")
    private Application application;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Resource> resources;
	
}
