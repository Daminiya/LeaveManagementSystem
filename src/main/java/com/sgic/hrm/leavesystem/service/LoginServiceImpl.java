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
	public boolean getLoginVerification(String userName, String password) {
		
		List<Login> authUser = loginRepository.findByUserNameAndPassword(userName, password);
		
		if(!authUser.isEmpty()) {
			return true;
		}
		
		return false;
	}

}
