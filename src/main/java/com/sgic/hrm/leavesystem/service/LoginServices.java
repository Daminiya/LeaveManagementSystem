package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.Login;

public interface LoginServices {

	boolean addLoginCredential(Login login);
	List<Login> getAllLoginCredentials();
	String getLoginVerification(String userName,String password);
}
