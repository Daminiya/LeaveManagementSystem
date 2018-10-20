package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.Department;


public interface DepartmentService {
   boolean addDepartment(Department department);
   List<Department> getAllDepartment();
   boolean editDepartment(Department department);
   boolean deleteDepartment(Integer id);
   Department getById(Integer id);
}
