package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.repository.LeaveRequestReposity;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
	@Autowired
	LeaveRequestReposity leaveRequestRepo;

	@Override
	public boolean addLeaveRequest(LeaveRequest obj) {
		leaveRequestRepo.save(obj);
		return true;
	}

	@Override
	public boolean deleteLeaveRequest(int id) {
		// TODO Auto-generated method stub
		leaveRequestRepo.deleteById(id);
		return false;
	}

	@Override
	public List<LeaveRequest> getData() {

		return leaveRequestRepo.findAll();
	}

	@Override
	public LeaveRequest findLeaveRequestById(int id) {
		// TODO Auto-generated method stub

		return leaveRequestRepo.findById(id);
	}

}
