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
	LeaveRequestReposity leaveRequestRepository;
	@Autowired
	StatusRepository statusRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean addLeaveRequest(LeaveRequest leaveRequest) {
		leaveRequestRepository.save(leaveRequest);
		return true;
	}

	@Override
	public boolean deleteLeaveRequest(int id) {
		leaveRequestRepository.deleteById(id);
		return false;
	}

	@Override
	public List<LeaveRequest> getData() {
		return leaveRequestRepository.findAll();
	}
	
	@Override
    public List<LeaveRequest> getDataBySort() {
        return leaveRequestRepository.sortByUpdatedAt();
    }

	@Override
	public LeaveRequest findLeaveRequestById(int id) {
		return leaveRequestRepository.findById(id).orElse(null);
	}

	@Override
	public boolean editLeaveRequestStatus(int id, int statusId) {
		LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElse(null);
		Status status = statusRepository.findById(statusId).orElse(null);
		if (leaveRequest != null) {
			leaveRequest.setStatusId(status);
			leaveRequestRepository.save(leaveRequest);
			return true;
		}
		return false;
	}

//who change the status and change status reflected in leave request table 
	@Override
	public boolean editLeaveRequestApproval(int id, int userId) {
		LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElse(null);
		User user = userRepository.findById(userId).orElse(null);
		
		if (leaveRequest != null) {
			leaveRequest.setApprovedBy(user);
			leaveRequestRepository.save(leaveRequest);
			return true;
		}
		return false;
	}

	// get details of leave request by user id
	@Override
	public List<LeaveRequest> findByUserId(Integer id) {
		return leaveRequestRepository.findByUser(id);
	}

	// date wise pick the leave request records
	@Override
	public List<LeaveRequest> findByDate(ZonedDateTime date) {
		return leaveRequestRepository.findByDate(date);
	}


}
