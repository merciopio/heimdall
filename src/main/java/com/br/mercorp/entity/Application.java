package com.br.mercorp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "APPLICATION", schema = "HEIMDALL",
    uniqueConstraints = { 
		@UniqueConstraint(name="uk_name_acronym",columnNames = {"NAME" ,"ACRONYM"} )
	})
public class Application extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 660365307268741542L;

	@Column(name = "ACRONYM")
	private String acronym;
    
	@NotEmpty (message = "{application.name.not.null}" )
	@Column(name = "NAME")
	private String name;
    
	@Column(name = "URL")
	private String url;
	
	@OneToMany(mappedBy="application", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Role> roles;
	
}

