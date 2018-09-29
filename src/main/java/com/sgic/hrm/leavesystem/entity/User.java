package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "user")

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -346839090403770783L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private ZonedDateTime joinDate;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "role_id")
	private Role roleId;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "department_id")
	private Department departmentId;

	private Integer servicePeriod;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ZonedDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(ZonedDateTime joinDate) {
		this.joinDate = joinDate;
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

	public Integer getServicePeriod() {
		return servicePeriod;
	}

	public void setServicePeriod(Integer servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
