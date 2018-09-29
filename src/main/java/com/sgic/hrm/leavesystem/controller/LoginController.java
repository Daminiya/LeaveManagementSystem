package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.service.LoginServices;

@RestController
public class LoginController {
	
	@Autowired
	LoginServices loginServices;
	
	@GetMapping("/login")
	public List<Login> viewAllLogin(){
		return loginServices.getAllLoginCredentials();
	}

	
}
