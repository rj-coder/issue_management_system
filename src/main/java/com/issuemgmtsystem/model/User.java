package com.issuemgmtsystem.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "users", schema = "ims")
@Getter
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 7246804827317235476L;

	@Id
	@Column(length = 10)
	private String username;

	@Column(nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", referencedColumnName = "role_id")
	private Set<Role> roles;

	@OneToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	private UserMaster userMaster;

}
