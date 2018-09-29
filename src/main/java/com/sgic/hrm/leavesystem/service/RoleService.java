package com.sgic.hrm.leavesystem.service;

import java.util.Optional;

import com.sgic.hrm.leavesystem.entity.Role;

public interface RoleService {
	Optional<Role> getRoleById(Integer id);
}
