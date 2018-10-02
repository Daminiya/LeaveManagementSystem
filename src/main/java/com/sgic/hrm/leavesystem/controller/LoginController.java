package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.model.LoginModel;
import com.sgic.hrm.leavesystem.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/login")
	public List<Login> viewAllLogin() {
		return loginService.getAllLoginCredentials();
	}

	@PostMapping("/login")
	public ResponseEntity<String> getLoginCredentials(HttpSession session, @RequestBody LoginModel loginModel) {

		if (loginService.getLoginVerification(loginModel.getUserName(), loginModel.getPassword())) {
			session.setAttribute("userName", loginModel.getUserName());
			return new ResponseEntity<>("Successfully loged in", HttpStatus.OK);

		}

		return new ResponseEntity<>("User not exists !", HttpStatus.BAD_REQUEST);

	}

}
