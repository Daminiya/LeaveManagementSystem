package com.sgic.hrm.leavesystem.Dto;

import java.time.ZonedDateTime;



public class UserModel {

	private int id;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private ZonedDateTime joinDate;
	private Integer roleId;
	private Integer departmentId;
	private Integer servicePeriod;
	private String password;

	public int getId() {
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getServicePeriod() {
		return servicePeriod;
	}

	public void setServicePeriod(Integer servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
