package com.sgic.hrm.leavesystem.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.model.UserModel;
import com.sgic.hrm.leavesystem.service.LeaveService;
import com.sgic.hrm.leavesystem.service.LoginService;
import com.sgic.hrm.leavesystem.service.ResourceNotFoundException;
import com.sgic.hrm.leavesystem.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private LoginService loginService;

	@Transactional
	@PostMapping("/user")
	public String createUser(@RequestBody UserModel userModel) {
		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setUserName(userModel.getUserName());
		user.setRoleId(userModel.getRoleId());
		user.setDepartmentId(userModel.getDepartmentId());
		user.setEmail(userModel.getEmail());
		user.setJoinDate(userModel.getJoinDate());
		user.setServicePeriod(userModel.getServicePeriod());
		userService.addUser(user);

		Login login = new Login();
		login.setUser(user);
		login.setDepartmentId(userModel.getDepartmentId());
		login.setPassword(userModel.getPassword());
		login.setRoleId(userModel.getRoleId());
		loginService.addLoginCredential(login);
		leaveService.addLeaveAllocation(userModel.getUserName());

		return "OK";
	}

	@GetMapping("/user")
	public List<User> getUser() {
		return userService.getUser();
	}

	@GetMapping("/user/{Id}")
	public User getUserById(@PathVariable("Id") Integer id) {
		try {
			return userService.getUserById(id);
		} catch (NoSuchElementException ex) {
			throw new ResourceNotFoundException();

		}
	}

	@GetMapping("/user/{Id}/department")
	public String getDepartmentByUserId(@PathVariable("Id") Integer id) {
		return userService.getUserDepartmentByUserId(id);
	}

	
	@Transactional
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable("id") Integer userId) {
		boolean test = false;
		boolean test1 = leaveService.deleteLeave(userId);	
		boolean test2 = loginService.deleteLogin(userId);		
		boolean test3 = userService.deleteUserById(userId);
		if(test2 && test1 && test3)
			test = true;
		return test;
	}


	@Transactional
	@PutMapping("/user/{Id}")
	public String editUser(@RequestBody UserModel userModel, @PathVariable("Id") Integer id) {
		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setUserName(userModel.getUserName());
		user.setRoleId(userModel.getRoleId());
		user.setDepartmentId(userModel.getDepartmentId());
		user.setEmail(userModel.getEmail());
		user.setJoinDate(userModel.getJoinDate());
		user.setServicePeriod(userModel.getServicePeriod());
		userService.editUser(user, id);

		//String userName=userModel.getFirstName();
		Login login = new Login();
		login.setDepartmentId(userModel.getDepartmentId());
		login.setPassword(userModel.getPassword());
		login.setRoleId(userModel.getRoleId());
		loginService.editLoginCredentials(login, id);

		return "ACCEPTED";
	}
}
