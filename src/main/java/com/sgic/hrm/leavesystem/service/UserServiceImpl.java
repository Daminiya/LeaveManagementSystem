package com.sgic.hrm.leavesystem.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
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
		User testUser = userRepository.getOne(userId);
		if (testUser != null) {
			User user = userRepository.getOne(userId);
			String testVar = user.getDepartmentId().getDepartmentName();
			return testVar;
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
}
