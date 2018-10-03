package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public boolean addLoginCredential(Login login) {
		loginRepository.save(login);
		return true;
	}

	@Override
	public List<Login> getAllLoginCredentials() {
		return loginRepository.findAll();
	}

	@Override
	public boolean getLoginVerification(String userName, String password) {

		List<Login> authUser = loginRepository.findByUserNameAndPassword(userName, password);

		if (!authUser.isEmpty()) {
			return true;
		}

		return false;
	}

	@Override
	public String getLogedUserRoleByUserName(String userName) {
		if (userName != null) {
			Login login = loginRepository.findByUserName(userName);
			String role = login.getRoleId().getRoleName();

			return role;

		}

		return null;
	}

	@Override
	public String getUserDepartmentByUserName(String userName) {
		if (userName != null) {
			Login login = loginRepository.findByUserName(userName);
			String department = login.getDepartmentId().getDepartmentName();

			return department;

		}

		return null;
	}
}
