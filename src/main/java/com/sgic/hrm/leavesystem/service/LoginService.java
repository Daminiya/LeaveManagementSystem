package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.Login;

public interface LoginService {

	boolean addLoginCredential(Login login);

	List<Login> getAllLoginCredentials();

	boolean getLoginVerification(String userName, String password);
	
	String getLogedUserRoleByUserName(String userName);
	
	String getUserDepartmentByUserName(String userName);
	
	boolean deleteLogin(Integer userId);

}
