package com.sgic.hrm.leavesystem.service;

import java.time.ZonedDateTime;
import java.util.List;

import com.sgic.hrm.leavesystem.entity.LeaveRequest;

public interface LeaveRequestService {

	// code done by kowsikan
	boolean addLeaveRequest(LeaveRequest leaveRequest);

	// code done by pakikaran
	boolean deleteLeaveRequest(int id);

	// functionality by kowsikan
	List<LeaveRequest> getData();

	// functionality by pakikaran
	LeaveRequest findLeaveRequestById(int id);

	// edit leave request thiru
	boolean editLeaveRequestStatus(int id, int statusId);

	// edit leave request Approved
	boolean editLeaveRequestApproval(int id, int userId);

	public List<LeaveRequest> findByUserId(Integer id);

	// date wise pick the leave request records done by fasla
	public List<LeaveRequest> findByDate(ZonedDateTime date);
	
	public List<LeaveRequest> getDataBySort();

}
