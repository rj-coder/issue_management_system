package com.issuemgmtsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.ToString;


@Entity
@Table(name = "user_master", schema = "ims")
@Getter
@ToString
public class UserMaster{
	@Id
	@Column(length=10)
	private String username;
	
	@Column(name="full_name",length=30)
	private String fullname;
	
	@Column(name = "dept_code")
	private Integer deptCode;
	
	@OneToOne
	@JoinColumn(insertable = false,updatable = false,name = "dept_code",referencedColumnName = "dept_code")
	private Department department;
}
