
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
	public boolean changeLieuLeaveCount(Integer userId, Integer leaveTypeId, Float update) {

		Leave updateLeave = leaveRepository.getLeaveById(userId, leaveTypeId);

		if (updateLeave != null) {
			leaveRepository.setRemainDays(updateLeave.getRemainDays() + update, updateLeave.getId());
			return true;
		}
		return false;
	}

}
