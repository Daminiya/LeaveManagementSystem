package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Department;
import com.sgic.hrm.leavesystem.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl  implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public boolean addDepartment(Department department) {
		departmentRepository.save(department);
		return true;
	}

	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}


	@Override
	public boolean editDepartment(Department department) {
		boolean success = false;
		if(departmentRepository.getOne(department.getId()) != null) {
			departmentRepository.save(department);
			success = true;
		}
		return success;
	}

	@Override
	public boolean deleteDepartment(Integer id) {
			Department department=departmentRepository.getOne(id);
			if (department.getId() == (id)) {
				departmentRepository.deleteById(id);
				return true;
			}
			return false;
	}

	@Override
	public Department getById(Integer id) {
		return departmentRepository.getOne(id);
	}


}
