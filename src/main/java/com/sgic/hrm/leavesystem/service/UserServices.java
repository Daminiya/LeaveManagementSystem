package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.User;

public interface UserServices {

	boolean addUser(User user);
	List<User> getUser();
	public String getUserDepartmentByUserId(Integer userId);
}
