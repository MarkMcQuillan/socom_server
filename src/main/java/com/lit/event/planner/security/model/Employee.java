package com.lit.event.planner.security.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
//@Data
@Table(name="employee")
public class Employee implements Serializable {
	@Id
	private String employeeId;
	private Date createdOn;
	private String email;
	private boolean isSocomMember;


	@Column(name="employeeID")
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name="employeeCreationDate")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name="employeeEmail")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "employeeIsSoComMember")
	public boolean isSocomMember() {
		return isSocomMember;
	}

	public void setSocomMember(boolean socomMember) {
		isSocomMember = socomMember;
	}

	public Employee(String employeeId,
					String email, boolean isSocomMember) {
		this();
		this.employeeId = employeeId;
		this.email = email;
		this.createdOn = new Date();
		 this.isSocomMember = isSocomMember;
	}

	public Employee() {
	}
}
