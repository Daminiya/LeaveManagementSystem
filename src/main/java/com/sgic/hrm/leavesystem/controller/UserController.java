package com.sgic.hrm.leavesystem.controller;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Role;
import com.sgic.hrm.leavesystem.Dto.EditUserDto;
import com.sgic.hrm.leavesystem.Dto.UserModel;

import com.sgic.hrm.leavesystem.entity.Department;
import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.entity.User;

import com.sgic.hrm.leavesystem.service.DepartmentService;
import com.sgic.hrm.leavesystem.service.LeaveService;
import com.sgic.hrm.leavesystem.service.LoginService;
import com.sgic.hrm.leavesystem.service.ResourceNotFoundException;
import com.sgic.hrm.leavesystem.service.RoleService;
import com.sgic.hrm.leavesystem.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private RoleService roleService;

	@Transactional
	@PostMapping("/user")
	public HttpStatus createUser(@RequestBody UserModel userModel) {

		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setUserName(userModel.getUserName());

		Role role = roleService.getRoleById(userModel.getRoleId());
		user.setRoleId(role);

		Department department = departmentService.getById(userModel.getDepartmentId());
		user.setDepartmentId(department);
		user.setEmail(userModel.getEmail());
		user.setJoinDate(userModel.getJoinDate());
		user.setServicePeriod(userModel.getServicePeriod());

		Login login = new Login();
		login.setUser(user);
		login.setDepartmentId(department);
		login.setPassword(userModel.getPassword());

		login.setRoleId(role);

		boolean res = userService.addUser(user) && loginService.addLoginCredential(login)
				&& leaveService.addLeaveAllocation(userModel.getUserName());
		if (res) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
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
		if (test2 && test1 && test3)
			test = true;
		return test;
	}

	@PutMapping("/user/{id}")
	public boolean editUser(@PathVariable("id") Integer id,@RequestBody EditUserDto editUser) {
		User user = userService.getUserById(id);
		user.setEmail(editUser.getEmail());
		user.setLastName(editUser.getLastName());
		user.setFirstName(editUser.getFirstName());
		Role role=roleService.getRoleById(editUser.getRoleId());
		user.setRoleId(role);
		Department department=departmentService.getById(editUser.getDepartmentId());
		user.setDepartmentId(department);
		user.setServicePeriod(editUser.getServicePeriod());
		
		if (userService.addUser(user)) {
			return true;
		}
		return false;
		
	}
	
	@GetMapping("/editUserModel")
	public EditUserDto getEditUserDto(){
		return new EditUserDto();
	}
}
