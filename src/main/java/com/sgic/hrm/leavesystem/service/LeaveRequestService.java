package com.sgic.hrm.leavesystem.service;

import java.util.List;


import com.sgic.hrm.leavesystem.entity.LeaveRequest;

public interface LeaveRequestService {

	//code done by kowsikan
	boolean addLeaveRequest(LeaveRequest obj);
	
	//code done by pakikaran
	boolean deleteLeaveRequest(int id);
	
	//functionality by kowsikan
	List<LeaveRequest> getData();
	
	// functionality by pakikaran
	LeaveRequest findLeaveRequestById(int id);
	
}
