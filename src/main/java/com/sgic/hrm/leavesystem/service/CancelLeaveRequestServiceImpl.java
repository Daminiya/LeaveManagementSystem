package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.CancelLeaveRequest;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.CancelLeaveRequestRepository;
import com.sgic.hrm.leavesystem.repository.LeaveRequestReposity;
import com.sgic.hrm.leavesystem.repository.UserRepository;

@Service
public class CancelLeaveRequestServiceImpl implements CancelLeaveRequestService {
	@Autowired
	CancelLeaveRequestRepository cancelLeaveRequestRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	LeaveRequestReposity leaveReqRepo;

	@Override
	public boolean addCancelLeaveRequest(CancelLeaveRequest cancelLeaveRequest) {
		cancelLeaveRequestRepo.save(cancelLeaveRequest);
		return true;
	}

	@Override
	public List<CancelLeaveRequest> getLeaveRequest() {
		// TODO Auto-generated method stub
		return cancelLeaveRequestRepo.findAll();
	}

	@Override
	public boolean editCancelRequestApproval(int leaveRequsetId, int userId) {
		CancelLeaveRequest cancelLeaveRequestObj = cancelLeaveRequestRepo
				.findByLeaveRequestId(leaveReqRepo.findById(leaveRequsetId));
		User userObj = userRepo.findById(userId);
		cancelLeaveRequestObj.setCancelledBy(userObj);
		cancelLeaveRequestRepo.save(cancelLeaveRequestObj);
		return true;
	}

}
