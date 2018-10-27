package com.sgic.hrm.leavesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Status;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.repository.StatusRepository;

@Service
public class StatusServiceImp implements StatusService {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public Iterable<Status> getAllStatus() {
		return statusRepository.findAll();
	}

	@Override
	public boolean save(Status status) {
		statusRepository.save(status);
		return true;
	}

	@Override
	public boolean delete(int id) {
		statusRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean editStatus(Status status, Integer id) {
		if (statusRepository.getOne(id) != null) {
			status.setId(id);
			statusRepository.save(status);
			return true;
		}
		return false;
	}
	
	public Status getStatusById(Integer id) {
	  Status status = statusRepository.findById(id).get();
      return status;
	}

}
