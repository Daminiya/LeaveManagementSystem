package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "login")
public class Login extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7100182369063236716L;

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
	private Integer id;
	private String password;
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "role_id")
	private Role roleId;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "department_id")
	private Department departmentId;

	private ZonedDateTime updatedAt;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// @JsonIgnore
	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

//	@JsonIgnore
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
