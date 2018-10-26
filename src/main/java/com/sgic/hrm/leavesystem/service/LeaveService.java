package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.Dto.LeaveStatisticsDto;
import com.sgic.hrm.leavesystem.entity.Leave;

public interface LeaveService {

	boolean addLeaveAllocation(String userName);
	boolean deleteLeave(Integer userId);

	// code done by Jerobert
	float increaseRemaingLeaveDays(float numOfDays, int userID, int leaveTypeId);

	// code done by Jerobert
	float decreaseRemaingLeaveDays(float numOfDays, int userID, int leaveTypeId);
	//remaining days 
	Leave findRemaingDays(int uid, int lid);
	//find remaining day by user 
	Iterable<LeaveStatisticsDto> findRemaingDays(Integer uid);

}
