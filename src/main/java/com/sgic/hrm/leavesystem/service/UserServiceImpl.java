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

	public boolean addUser(User user) {
		userRepository.save(user);
		return true;
	}

	public List<User> getUser() {
		return userRepository.findAll();
	}

	public String getUserDepartmentByUserId(Integer userId) {
		User user = userRepository.getOne(userId);
		if (user != null) {
			String department = user.getDepartmentId().getDepartmentName();
			return department;
		}
		return "Failed";

	}

	public User getUserById(Integer id) throws NoSuchElementException {
		User user = userRepository.findById(id).get();
		return user;
	}

	public boolean deleteUserById(Integer userId) {
		boolean success = false;
		if (userRepository.findById(userId).isPresent()) {
			userRepository.deleteById(userId);
			success = true;
		}
		return success;
	}
}
