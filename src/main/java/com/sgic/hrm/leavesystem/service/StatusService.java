package com.sgic.hrm.leavesystem.service;

import com.sgic.hrm.leavesystem.entity.Status;

public interface StatusService {

	public Iterable<Status> getAllStatus();
	boolean save(Status status);
	boolean delete(int id);
	boolean editStatus(Status status, Integer id);
	Status getStatusById(Integer id);
}

