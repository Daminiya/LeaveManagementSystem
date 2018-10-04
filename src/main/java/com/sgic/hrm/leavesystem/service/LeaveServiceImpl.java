package com.sgic.hrm.leavesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Leave;
import com.sgic.hrm.leavesystem.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	LeaveRepository leaveRepo;

	@Override
	public float increaseRemaingLeaveDays(float numOfDays, int userId, int leaveTypeId) {
		Leave leaveObj = leaveRepo.findRemaingDaysByUserIdAndLeaveTypeId(userId, leaveTypeId);
		float newRemaingDays = leaveObj.getRemainDays() + numOfDays;
		leaveObj.setRemainDays(newRemaingDays);
		leaveRepo.save(leaveObj);
		return newRemaingDays;
	}

	@Override
	public float decreaseRemaingLeaveDays(float numOfDays, int userId, int leaveTypeId) {
		Leave leaveObj = leaveRepo.findRemaingDaysByUserIdAndLeaveTypeId(userId, leaveTypeId);
		float newRemaingDays = leaveObj.getRemainDays() - numOfDays;
		leaveObj.setRemainDays(newRemaingDays);
		leaveRepo.save(leaveObj);
		return newRemaingDays;
	}

}
