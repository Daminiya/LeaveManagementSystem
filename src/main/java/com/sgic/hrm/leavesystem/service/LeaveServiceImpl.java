package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.hrm.leavesystem.entity.Leave;
import com.sgic.hrm.leavesystem.entity.LeaveType;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.LeaveRepository;
import com.sgic.hrm.leavesystem.repository.UserRepository;

@Transactional
@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;
	@Autowired
	private LeaveTypeService leaveTypeService;
	@Autowired
	UserRepository UserRepository;

	@Override
	public boolean addLeaveAllocation(String userName) {

		User user = UserRepository.findByUserName(userName);
		List<LeaveType> leaveType = leaveTypeService.getLeaveType();

		for (LeaveType lt : leaveType) {
			Leave leave = new Leave();
			leave.setUserId(user);
			leave.setLeaveTypeId(lt);
			if (lt.getLeaveType().equals("Annual")) {
				leave.setRemainDays(0);
			} else {
				leave.setRemainDays(lt.getAllocationDays());
			}
			leave.setUtilizedDays(0);
			leaveRepository.save(leave);
		}
		return true;
	}

	@Override
	public boolean deleteLeaves(Integer userId) {
		List<Leave> leaves = leaveRepository.getLeavesByUserId(userId);
		for (Leave leave : leaves) {
			leaveRepository.deleteById(leave.getId());
		}
		return true;
	}

	@Override
	public float increaseRemaingLeaveDays(float numOfDays, int userId, int leaveTypeId) {
		Leave leaveObj = leaveRepository.findRemaingDaysByUserIdAndLeaveTypeId(userId, leaveTypeId);
		float newRemaingDays = leaveObj.getRemainDays() + numOfDays;
		leaveObj.setRemainDays(newRemaingDays);
		leaveRepository.save(leaveObj);
		return newRemaingDays;
	}

	@Override
	public float decreaseRemaingLeaveDays(float numOfDays, int userId, int leaveTypeId) {
		Leave leaveObj = leaveRepository.findRemaingDaysByUserIdAndLeaveTypeId(userId, leaveTypeId);
		float newRemaingDays = leaveObj.getRemainDays() - numOfDays;
		leaveObj.setRemainDays(newRemaingDays);
		leaveRepository.save(leaveObj);
		return newRemaingDays;
	}

}
