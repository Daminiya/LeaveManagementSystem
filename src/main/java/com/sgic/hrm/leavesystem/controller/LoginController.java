package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginServices;

	@GetMapping("/login")
	public List<Login> viewAllLogin() {
		return loginServices.getAllLoginCredentials();
	}

	@GetMapping("/login/user")
	public ResponseEntity<String> getLoginCredentials(HttpSession session,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password) {

		
		if (loginServices.getLoginVerification(userName, password)) {
			session.setAttribute("userName", userName);
			return new ResponseEntity<>(userName, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}