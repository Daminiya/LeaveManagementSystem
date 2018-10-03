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
import com.sgic.hrm.leavesystem.model.LoggedUserModel;
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
	public ResponseEntity<LoggedUserModel> getLoginCredentials(HttpSession session, @RequestBody LoginModel loginModel) {

		String loginUserName = loginModel.getUserName();
		String loginPassword = loginModel.getPassword();
		if (loginService.getLoginVerification(loginUserName, loginPassword)) {
			session.setAttribute("userName", loginUserName);
			String department = loginService.getUserDepartmentByUserName(loginUserName);
			String role = loginService.getLogedUserRoleByUserName(loginUserName);
			
			LoggedUserModel loggedUserModel = new LoggedUserModel();
			loggedUserModel.setUserName(loginUserName);
			loggedUserModel.setUserRole(role);
			loggedUserModel.setUserDepartment(department);
			
			//return new ResponseEntity<>("Successfully loged "+loginUserName+" - "+role+" - "+department, HttpStatus.OK);
			return new ResponseEntity<>(loggedUserModel, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

}
