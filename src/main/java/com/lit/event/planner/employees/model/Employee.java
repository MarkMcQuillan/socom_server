package com.lit.event.planner.employees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="employee")
public class Employee implements Serializable {
	@Id
	private String employeeId;
	private Date createdOn;
	private String email;
	private boolean isSocomMember;


	@Column(name="employee_id")
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name="created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "is_socom_member")
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

}
