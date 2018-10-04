package com.sgic.hrm.leavesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	UserRepository userRepo;

	@Override
	public User findUserById(int id) {
		return userRepo.findById(id);
	}

}
