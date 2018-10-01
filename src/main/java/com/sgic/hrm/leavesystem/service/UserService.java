package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.User;

public interface UserService {
	
	   boolean addUser(User user);
	   List<User> getAllUsers();
	   boolean editUser(User user);
	   boolean deleteUser(Integer id);
	   User getById(Integer id);
}
