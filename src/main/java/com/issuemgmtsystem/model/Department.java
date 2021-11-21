package com.issuemgmtsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.ToString;

@Table(name = "departments")
@Entity
@Getter
@ToString
public class Department {
	@Id
	@Column(name = "dept_code")
	private Integer departmentCode;

	@Column(name = "dept_name")
	private String departmentName;

}
