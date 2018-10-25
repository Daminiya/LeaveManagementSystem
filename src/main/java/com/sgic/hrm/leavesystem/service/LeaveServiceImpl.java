package com.sgic.hrm.leavesystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.Dto.LeaveStatisticsDto;
import com.sgic.hrm.leavesystem.entity.Leave;
import com.sgic.hrm.leavesystem.entity.LeaveType;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.LeaveRepository;
import com.sgic.hrm.leavesystem.repository.UserRepository;

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
	public boolean deleteLeave(Integer userId) {
		List<Leave> leave = leaveRepository.getLeaveByUserId(userId);
		for (Leave l : leave) {
			leaveRepository.deleteById(l.getId());
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

	@Override
	public Leave findRemaingDays(int uid, int lid) {
		return leaveRepository.findRemaingDaysByUserIdAndLeaveTypeId(uid, lid);
	}

	@Override
	public Iterable<LeaveStatisticsDto> findRemaingDays(Integer uid) {
		
		List<LeaveStatisticsDto> objList=new ArrayList<>();
		Iterable<Leave> iterator=leaveRepository.findByUserId(uid);
		for (Leave leave : iterator) {
			LeaveStatisticsDto obj=new LeaveStatisticsDto();
			obj.setLeaveTypeId(leave.getLeaveTypeId().getId());
			obj.setLeaveType(leave.getLeaveTypeId().getLeaveType());
			obj.setAllocationDays(leave.getLeaveTypeId().getAllocationDays());
			obj.setRemainingDays(leave.getRemainDays());
			objList.add(obj);
		}

		return objList;
	}

}
