package com.sgic.hrm.leavesystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Role;
import com.sgic.hrm.leavesystem.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Optional<Role> getRoleById(Integer id) {
		
		return roleRepository.findById(id);
	}

}
