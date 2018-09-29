package com.sgic.hrm.leavesystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Role;
import com.sgic.hrm.leavesystem.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	List<Role> role = new ArrayList<>();

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public boolean addRole(Role role) {
		roleRepository.save(role);
		return true;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public boolean editRole(Role role, Integer id) {
		boolean success = false;
		if (roleRepository.getOne(id) != null) {
			role.setId(id);
			roleRepository.save(role);
			success = true;
		}
		return success;
	}

}
