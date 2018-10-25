package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.LoginRepository;
import com.sgic.hrm.leavesystem.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private UserRepository userRepository;

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

	@Override
	public boolean deleteLogin(Integer userId) {
		boolean status = false;

		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			Login login = loginRepository.findByUserName(user.getUserName());

			loginRepository.deleteById(login.getId());
			status = true;
		}
		return status;
	}
	
	@Override
	public int getLoggedUserIdByUserName(String userName) {
	  if(userName != null) {
	    Login login = loginRepository.findByUserName(userName);
	    Integer userId = login.getUser().getId();
	    
	    return userId;
	  }
	  
	  return 0;
	}
}
