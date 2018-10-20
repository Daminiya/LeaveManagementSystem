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
	CancelLeaveRequestRepository cancelLeaveRequestRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	LeaveRequestReposity leaveReqRepository;

	@Override
	public boolean addCancelLeaveRequest(CancelLeaveRequest cancelLeaveRequest) {
		cancelLeaveRequestRepository.save(cancelLeaveRequest);
		return true;
	}

	@Override
	public List<CancelLeaveRequest> getLeaveRequest() {
		return cancelLeaveRequestRepository.findAll();
	}

	@Override
	public boolean editCancelRequestApproval(int leaveRequsetId, int userId) {
		CancelLeaveRequest cancelLeaveRequestObj = cancelLeaveRequestRepository
				.findByLeaveRequestId(leaveReqRepository.findById(leaveRequsetId).orElse(null));
		User userObj = userRepository.findById(userId).orElse(null);
		
		cancelLeaveRequestObj.setCancelledBy(userObj);
		cancelLeaveRequestRepository.save(cancelLeaveRequestObj);
		return true;
	}

}
