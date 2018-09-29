package com.sgic.hrm.leavesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Status;
import com.sgic.hrm.leavesystem.repository.StatusRepository;

@Service
public class StatusServiceImp implements StatusService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	public Iterable<Status> getAllStatus(){
		return statusRepository.findAll();
	}
	

}
