package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.repository.LoginRepository;

@Transactional
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

	public boolean editLoginCredentials(Login login , Integer id) {
		boolean success= false;
		if (
			loginRepository.getOne(id)!=null) {
			loginRepository.save(login);
			success=true;
			return success;
		}
		return success;
		
	}

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
