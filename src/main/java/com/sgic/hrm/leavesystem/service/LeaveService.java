package com.sgic.hrm.leavesystem.service;

public interface LeaveService {

	boolean addLeaveAllocation(String userName);
	boolean deleteLeave(Integer userId);
}
