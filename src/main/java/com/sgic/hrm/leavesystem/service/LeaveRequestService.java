package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.LeaveRequest;

public interface LeaveRequestService {
	 boolean addLeaveRequest(LeaveRequest leaveRequest);
	   List<LeaveRequest> getAllLeaveRequests();
	   boolean editLeaveRequest(LeaveRequest leaveRequest);
	   boolean deleteLeaveRequest(Integer id);
	   LeaveRequest getById(Integer id);

}
