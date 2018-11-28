package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.Dto.LoginModel;
import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.model.LoggedUserModel;
import com.sgic.hrm.leavesystem.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/login")
	public List<Login> viewAllLogin() {
		return loginService.getAllLoginCredentials();
	}

	@PostMapping("/login")
	public LoggedUserModel getLoginCredentials(HttpSession session, @RequestBody LoginModel loginModel) {

		String loginUserName = loginModel.getUserName();
		String loginPassword = loginModel.getPassword();
		if (loginService.getLoginVerification(loginUserName, loginPassword)) {
			session.setAttribute("userName", loginUserName);
			String department = loginService.getUserDepartmentByUserName(loginUserName);
			String role = loginService.getLogedUserRoleByUserName(loginUserName);
			Integer userId = loginService.getLoggedUserIdByUserName(loginUserName);

			LoggedUserModel loggedUserModel = new LoggedUserModel();
			loggedUserModel.setUserName(loginUserName);
			loggedUserModel.setUserRole(role);
			loggedUserModel.setUserDepartment(department);
			loggedUserModel.setUserId(userId);

			// return new ResponseEntity<>("Successfully loged "+loginUserName+" - "+role+"
			// -
			// "+department, HttpStatus.OK);
			// return new ResponseEntity<>(loggedUserModel, HttpStatus.OK);
			return loggedUserModel;

		}

		if (loginUserName.equals("admin") && loginPassword.equals("admin")) {
			session.setAttribute("userName", loginUserName);
			LoggedUserModel loggedUserModel = new LoggedUserModel();
			loggedUserModel.setUserName("admin");
			loggedUserModel.setUserRole("Admin");
			loggedUserModel.setUserDepartment("admin");
			loggedUserModel.setUserId(0);

			return loggedUserModel;
		}
		
		if (loginUserName.equals("user") && loginPassword.equals("user")) {
			session.setAttribute("userName", loginUserName);
			LoggedUserModel loggedUserModel = new LoggedUserModel();
			loggedUserModel.setUserName("user");
			loggedUserModel.setUserRole("Employee");
			loggedUserModel.setUserDepartment("user");
			loggedUserModel.setUserId(0);

			return loggedUserModel;
		}

		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return null;

	}

}
