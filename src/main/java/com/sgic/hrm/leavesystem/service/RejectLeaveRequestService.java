package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.RejectLeaveRequest;

public interface RejectLeaveRequestService {
	
	boolean addRejectLeaveRequest(RejectLeaveRequest rejectLeaveRequest);
    List<RejectLeaveRequest> getAllRejectLeaveRequests();
    boolean editRejectLeaveRequest(RejectLeaveRequest rejectLeaveRequest);
    boolean deleteRejectLeaveRequest(Integer id);
    RejectLeaveRequest getById(Integer id);
}
