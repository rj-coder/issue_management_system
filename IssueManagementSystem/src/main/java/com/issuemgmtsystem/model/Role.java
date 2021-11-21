package com.issuemgmtsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.ToString;

@Table(name = "roles",schema="ims")
@Entity
@ToString
@Getter
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 5385734703316604372L;

	@Id
	private Integer roleId;
	
	@Column(name = "role_description",length=20)
	private String roleDescription;

	@Override
	public String getAuthority() {
		return  roleDescription;
	}
	
}
