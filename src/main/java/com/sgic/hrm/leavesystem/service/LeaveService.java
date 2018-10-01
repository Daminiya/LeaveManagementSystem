package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.Leave;

public interface LeaveService {
	
	boolean addLeave(Leave leave);
    List<Leave> getAllLeaves();
    boolean editLeave(Leave leave);
    boolean deleteLeave(Integer id);
    Leave getById(Integer id);
}
