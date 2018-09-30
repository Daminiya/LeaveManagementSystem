package com.sgic.hrm.leavesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Leave;
import com.sgic.hrm.leavesystem.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService{
	@Autowired
	private LeaveRepository leaveRepository;
	
	@Override
	public boolean addLeaveAllocation(Leave leave) {
		leaveRepository.save(leave);
		return true;
	}
	
	
}
