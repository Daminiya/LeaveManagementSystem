package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Login;
import com.sgic.hrm.leavesystem.repository.LoginRepository;

@Service
public class LoginServicesImpl implements LoginServices{
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public boolean addLoginCredential(Login login){
		
		loginRepository.save(login);
		return true;
	}

	@Override
	public List<Login> getAllLoginCredentials() {
		return loginRepository.findAll();
	}

	@Override
	public String getLoginVerification(String userName, String password) {
		
		Login authUser = loginRepository.findByUserNameAndPassword(userName, password);
		
		return authUser.getUser().getUserName();
	}
}
