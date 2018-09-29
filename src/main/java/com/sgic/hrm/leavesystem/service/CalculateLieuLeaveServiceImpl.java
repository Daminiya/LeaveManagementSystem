
package com.sgic.hrm.leavesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Leave;
import com.sgic.hrm.leavesystem.repository.LeaveRepository;

@Service
public class CalculateLieuLeaveServiceImpl implements CalculateLieuLeaveService {

	@Autowired
	LeaveRepository leaveRepository;


	@Override
	public boolean changeLieuLeaveCount(Leave leave, Integer id, Float update) {
		boolean success = false;
		if (leaveRepository.getOne(id) != null) {
			leaveRepository.setRemainDays(((Leave) leaveRepository).getRemainDays()+update);
			leaveRepository.save(leave);
			success = true;
			return success;
		}
		return success;
	}
}
