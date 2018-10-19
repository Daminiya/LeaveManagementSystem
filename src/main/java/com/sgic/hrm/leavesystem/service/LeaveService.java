package com.sgic.hrm.leavesystem.service;

public interface LeaveService {

	boolean addLeaveAllocation(String userName);
	boolean deleteLeaves(Integer userId);

	// code done by Jerobert
	float increaseRemaingLeaveDays(float numOfDays, int userID, int leaveTypeId);

	// code done by Jerobert
	float decreaseRemaingLeaveDays(float numOfDays, int userID, int leaveTypeId);

}
