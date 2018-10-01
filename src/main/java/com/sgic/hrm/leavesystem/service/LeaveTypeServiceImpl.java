package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.LeaveType;
import com.sgic.hrm.leavesystem.repository.LeaveTypeRepository;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{

	@Autowired
	LeaveTypeRepository leaveTypeRepo;
	
	@Override
	public List<LeaveType> getLeaveType() {		
		return leaveTypeRepo.findAll();
	}

}
