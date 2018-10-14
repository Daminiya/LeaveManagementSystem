package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.LeaveType;
import com.sgic.hrm.leavesystem.repository.LeaveTypeRepository;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

	@Autowired

	LeaveTypeRepository leaveTypeRepository;

	@Override
	public boolean addLeaveType(LeaveType leavetype) {
		leaveTypeRepository.save(leavetype);
		return true;
	}

	@Override
	public List<LeaveType> getLeaveType() {

		return leaveTypeRepository.findAll();
	}

	@Override
	public boolean editLeaveType(LeaveType leaveType, Integer id) {
		boolean success = false;
		if (leaveTypeRepository.getOne(id) != null) {
			leaveType.setId(id);
			leaveTypeRepository.save(leaveType);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteLeaveType(Integer id) {
		if (leaveTypeRepository.getOne(id) != null) {
			leaveTypeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public LeaveType getLeaveTypeById(int id) {
		// TODO Auto-generated method stub
		
		return leaveTypeRepository.findById(id);
	}

}
