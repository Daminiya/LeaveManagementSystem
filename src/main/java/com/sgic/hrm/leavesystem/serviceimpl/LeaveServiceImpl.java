package com.sgic.hrm.leavesystem.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Leave;
import com.sgic.hrm.leavesystem.repository.LeaveRepository;
import com.sgic.hrm.leavesystem.service.LeaveService;

@Service
public class LeaveServiceImpl  implements LeaveService{
	
	@Autowired
	private LeaveRepository LeaveRepository;

	@Override
	public boolean addLeave(Leave leave) {
		LeaveRepository.save(leave);
		return true;
	}

	@Override
	public List<Leave> getAllLeaves() {
		return LeaveRepository.findAll();
	}

	@Override
	public boolean editLeave(Leave leave) {
		boolean success = false;
		if(LeaveRepository.getOne(leave.getId()) != null) {
			LeaveRepository.save(leave);
			success = true;
		}
		return success;
	}

	@Override
	public boolean deleteLeave(Integer id) {
			Leave Leave=LeaveRepository.getOne(id);
			if (Leave.getId() == (id)) {
				LeaveRepository.deleteById(id);
				return true;
			}
			return false;
	}

	@Override
	public Leave getById(Integer id) {
		return LeaveRepository.getOne(id);
	}


}
