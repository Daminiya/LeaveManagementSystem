package com.sgic.hrm.leavesystem.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.model.UserModel;
import com.sgic.hrm.leavesystem.service.LoginServices;
import com.sgic.hrm.leavesystem.service.ResourceNotFoundException;
import com.sgic.hrm.leavesystem.service.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices userService;
//	@Autowired
//	private LeaveServices leaveService;
	@Autowired
	private LoginServices loginServices;
	
	@PostMapping("/user")
	public String createUser(@RequestBody UserModel userModel) {
		User u = new User();
		u.setFirstName(userModel.getFirstName());
		u.setLastName(userModel.getLastName());
		u.setUserName(userModel.getUserName());
		u.setRoleId(userModel.getRoleId());
		u.setDepartmentId(userModel.getDepartmentId());
		u.setEmail(userModel.getEmail());
		u.setJoinDate(userModel.getJoinDate());
		u.setServicePeriod(userModel.getServicePeriod());
		userService.addUser(u);
		
		Login login = new Login();
		login.setUser(u);
		login.setDepartmentId(userModel.getDepartmentId());
		login.setPassword(userModel.getPassword());
		login.setRoleId(userModel.getRoleId());
		loginServices.addLoginCredential(login);
		return "OK";
	}
	
	@GetMapping("/user")
	public List<User> getUser(){
		return userService.getUser();
	}
	
	@GetMapping("/user/{Id}")
	public User getUserById(@PathVariable("Id") Integer id) {
		try {
			return userService.getUserById(id);
		}
		catch(NoSuchElementException ex) {
			throw new ResourceNotFoundException();
		
		}
	}
	
	@GetMapping("/user/{Id}/department")
	public String getDepartmentByUserId(@PathVariable("Id") Integer id) {
		return userService.getUserDepartmentByUserId(id);
	}
}



