package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.LeaveType;

public interface LeaveTypeService {
	boolean addLeaveType(LeaveType leavetype);
	List<LeaveType> getLeaveType();
	boolean editLeaveType(LeaveType leaveType,Integer id);
	boolean deleteLeaveType(Integer id);
	
}
