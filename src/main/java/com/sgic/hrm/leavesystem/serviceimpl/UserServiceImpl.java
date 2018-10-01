package com.sgic.hrm.leavesystem.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.UserRepository;
import com.sgic.hrm.leavesystem.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository UserRepository;

	@Override
	public boolean addUser(User user) {
		UserRepository.save(user);
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		return UserRepository.findAll();
	}

	@Override
	public boolean editUser(User user) {
		boolean success = false;
		if(UserRepository.getOne(user.getId()) != null) {
			UserRepository.save(user);
			success = true;
		}
		return success;
	}

	@Override
	public boolean deleteUser(Integer id) {
			User User=UserRepository.getOne(id);
			if (User.getId() == (id)) {
				UserRepository.deleteById(id);
				return true;
			}
			return false;
	}

	@Override
	public User getById(Integer id) {
		return UserRepository.getOne(id);
	}


}
