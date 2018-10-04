package com.sgic.hrm.leavesystem.service;

import java.util.List;
import com.sgic.hrm.leavesystem.entity.Role;
public interface RoleService {
	
	boolean addRole(Role role);

	List<Role> getAllRoles();

	boolean editRole(Role role, Integer id);
}
