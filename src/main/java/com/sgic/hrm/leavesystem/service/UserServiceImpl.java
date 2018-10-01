package com.sgic.hrm.leavesystem.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean addUser(User user) {
		userRepository.save(user);
		return true;
	}

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public String getUserDepartmentByUserId(Integer userId) {
		User user = userRepository.getOne(userId);
		if (user != null) {
			 user = userRepository.getOne(userId);
			String department = user.getDepartmentId().getDepartmentName();
			return department;
		}
		return "Failed";

	}

	@Override
	public User getUserById(Integer id) throws NoSuchElementException {
		User user = userRepository.findById(id).get();
		return user;		
	}

}