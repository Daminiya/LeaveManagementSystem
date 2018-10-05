package com.sgic.hrm.leavesystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.RejectLeaveRequest;
import com.sgic.hrm.leavesystem.repository.RejectLeaveRequestRepository;

@Service
public class RejectLeaveRequestServiceImpl implements RejectLeaveRequestService {

	@Autowired
	RejectLeaveRequestRepository rejectLeaveRequestRepository;
	List<RejectLeaveRequest> rejectLeave = new ArrayList<>();

	@Override
	public boolean addRejectLeaveRequest(RejectLeaveRequest rejectLeave) {
		rejectLeaveRequestRepository.save(rejectLeave);
		return true;
	}

}
