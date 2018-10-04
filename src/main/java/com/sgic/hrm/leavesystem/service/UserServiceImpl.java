package com.sgic.hrm.leavesystem.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.UserRepository;

@Transactional
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
			String department = user.getDepartmentId().getDepartmentName();
			return department;
		}
		return "Failed";

	}

	@Override
	public boolean editUser(User user, Integer id) {
		boolean success= false;
		if (userRepository.getOne(id)!=null) {
			user.setId(id);
			userRepository.save(user);
			success=true;
	
		}
		return success;
	}

	@Override
	public User getUserById(Integer id) throws NoSuchElementException {
		User user = userRepository.findById(id).get();
		return user;		
	}

}
