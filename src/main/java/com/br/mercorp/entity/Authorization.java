package com.br.mercorp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "AUTHORIZATION", schema = "HEIMDALL",
uniqueConstraints = { 
	@UniqueConstraint(name="uk_user_application_role",columnNames = {"ID_USER","ID_APPLICATION","ID_ROLE"} )
})
public class Authorization extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -9070143189607343692L;

	@NotEmpty(message = "{authorization.user.not.null}")
	@ManyToOne
    @JoinColumn(name = "ID_USER" , nullable = false)
    private User user;
    
	@NotEmpty(message = "{authorization.application.not.null}")
    @ManyToOne
    @JoinColumn(name = "ID_APPLICATION", nullable = false)
    private Application application;

	@NotEmpty(message = "{authorization.role.not.null}")
    @ManyToOne
    @JoinColumn(name = "ID_ROLE" , nullable = false)
    private Role role;

}
