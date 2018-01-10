package com.br.mercorp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.joda.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable  {
	
	private static final long serialVersionUID = 5045242643174128662L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Version
    @Column(name = "VERSION", nullable = false)
    protected int version;

	@Column(name = "DATE_ADDED", nullable = false)
	private LocalDateTime dateAdded;
	
	@Column(name = "DATE_EDITED")
    private LocalDateTime dateEdited;

	@PrePersist
    public void onPrePersist() {
		new LocalDateTime();
		dateAdded = LocalDateTime.now();
		version = 0;
    }
      
    @PreUpdate
    public void onPreUpdate() {
    	new LocalDateTime();
    	dateEdited = new LocalDateTime();
    	int new_version = version++;
		version = new_version;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		final BaseEntity other = (BaseEntity) obj;
		
		if (id != other.id && (id == null || !id.equals(other.id))) {
			return false;
		}
		
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + (id != null ? id.hashCode() : 0);
		return hash;
	}

}
