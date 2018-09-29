package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.leavesystem.entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer>{

}
