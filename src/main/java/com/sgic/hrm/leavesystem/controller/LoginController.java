package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/login")
	public ResponseEntity<String> getLoginCredentials(
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password) {
		
		if(userName != null && password != null) {
			String authUser = loginServices.getLoginVerification(userName, password);
			
			return new ResponseEntity<>(authUser,HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
