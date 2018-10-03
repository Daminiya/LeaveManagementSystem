package com.sgic.hrm.leavesystem.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.entity.Status;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.LeaveRequestReposity;
import com.sgic.hrm.leavesystem.repository.StatusRepository;
import com.sgic.hrm.leavesystem.repository.UserRepository;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
	@Autowired
	LeaveRequestReposity leaveRequestRepo;
	@Autowired
	StatusRepository statusRepo;
	@Autowired
	UserRepository userRepo;

	@Override
	public boolean addLeaveRequest(LeaveRequest obj) {
		leaveRequestRepo.save(obj);
		return true;
	}

	@Override
	public boolean deleteLeaveRequest(int id) {
		leaveRequestRepo.deleteById(id);
		return false;
	}

	@Override
	public List<LeaveRequest> getData() {
		return leaveRequestRepo.findAll();
	}

	@Override
	public LeaveRequest findLeaveRequestById(int id) {
		return leaveRequestRepo.findById(id);
	}

	@Override
	public boolean editLeaveRequestStatus(int id, int statusId) {
		LeaveRequest lrObj = leaveRequestRepo.findById(id);
		Status statusObj = statusRepo.findById(statusId);
		lrObj.setStatusId(statusObj);
		leaveRequestRepo.save(lrObj);
		return true;
	}

//who change the status and change status reflected in leave request table 
	@Override
	public boolean editLeaveRequestApproval(int id, int userId) {
		LeaveRequest lrObj = leaveRequestRepo.findById(id);
		User userObj = userRepo.findById(userId);
		lrObj.setUserId(userObj);
		leaveRequestRepo.save(lrObj);
		return true;
	}

	// get details of leave request by user id
	@Override
	public Iterable<LeaveRequest> findByUserId(User id) {
		return leaveRequestRepo.findByUserId(id);
	}

	// date wise pick the leave request records
	@Override
	public List<LeaveRequest> findByDate(ZonedDateTime abc) {
		// TODO Auto-generated method stub
		return leaveRequestRepo.findByDate(abc);
	}

}
