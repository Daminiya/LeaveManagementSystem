package com.sgic.hrm.leavesystem.controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.leavesystem.entity.Role;
import com.sgic.hrm.leavesystem.service.RoleService;



@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/role")
	public HttpStatus AddRole(@Valid @RequestBody Role role) {
		boolean test = roleService.addRole(role);
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	@GetMapping("/role")
	public ResponseEntity<List<Role>> Getrole() {
		List<Role> role = roleService.getAllRoles();
		ResponseEntity<List<Role>> response = new ResponseEntity<>(role, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/role/{id}")
	public HttpStatus ModifyRole(@PathVariable Integer id,@RequestBody Role role) {
	boolean test = roleService.editRole(role, id);
	if (test) {
	return HttpStatus.ACCEPTED;
	}
	return HttpStatus.BAD_REQUEST;

	}
}
