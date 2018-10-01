package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.CancelLeaveRequest;

public interface CancelLeaveRequestService {
	
   boolean addCancelLeaveRequest(CancelLeaveRequest cancelLeaveRequest);
   List<CancelLeaveRequest> getAllCancelLeaveRequests();
   boolean editCancelLeaveRequest(CancelLeaveRequest cancelLeaveRequest);
   boolean deleteCancelLeaveRequest(Integer id);
   CancelLeaveRequest getById(Integer id);
}
 