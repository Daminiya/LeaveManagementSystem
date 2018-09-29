package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "login")
public class Login implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7100182369063236716L;
	@Id
	private String userName;
	private String password;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="role_id")
	private Role roleId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="department_id")
	private Department departmentId;
	
	private ZonedDateTime updatedAt;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
