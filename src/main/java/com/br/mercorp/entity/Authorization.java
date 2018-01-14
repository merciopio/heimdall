package com.br.mercorp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "AUTHORIZATION", schema = "HEIMDALL",
uniqueConstraints = { 
	@UniqueConstraint(name="uk_user_role",columnNames = {"ID_USER","ID_ROLE"} )
})
public class Authorization extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -9070143189607343692L;

	//@NotEmpty(message = "{authorization.user.not.null}")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER" , nullable = false)
    private User user;
    
	//@NotEmpty(message = "{authorization.role.not.null}")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROLE" , nullable = false)
    private Role role;

}
