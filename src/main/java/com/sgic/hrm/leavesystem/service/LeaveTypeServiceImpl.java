package com.sgic.hrm.leavesystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.LeaveType;
import com.sgic.hrm.leavesystem.repository.LeaveTypeRepository;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{

	@Autowired
	LeaveTypeRepository leaveTypeRepository; 
	
	List<LeaveType> leavetype=new ArrayList<>();
	
	@Override
	public boolean addLeaveType(LeaveType leavetype) {
		leaveTypeRepository.save(leavetype);
		return true;
	}

	@Override
	public List<LeaveType> getLeaveType() {
		leavetype=leaveTypeRepository.findAll();
		return leavetype;
	}

	@Override
	public boolean editLeaveType(LeaveType leaveType, Integer id) {
		boolean success=false;
		if(leaveTypeRepository.getOne(id)!=null) {
			leaveType.setId(id);
			leaveTypeRepository.save(leaveType);
			success=true;
			return success;
		}
		return success;
	}
	
	@Override
	public boolean deleteLeaveType(Integer id){
		if(leaveTypeRepository.getOne(id)!=null){
			leaveTypeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
