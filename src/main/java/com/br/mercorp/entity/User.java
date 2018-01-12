package com.br.mercorp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER", schema = "HEIMDALL")
public class User extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6774168322973517539L;
    
	@NotEmpty(message = "{user.name.not.null}")
	@Column(name = "NAME")
	private String name;
    
	@NotEmpty(message = "{user.login.not.null}")
	@Column(name = "login")
	private String login;
	
	@Email
	@NotEmpty(message = "{user.email.not.null}")
	@Column(name = "email")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Transient
	private List<Role> roles;
    	
	public boolean isInRole(Role role) {
		if (roles.contains(role)) {
			return true;
		}
		return false;
	}
}
