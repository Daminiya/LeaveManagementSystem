package com.sgic.hrm.leavesystem.service;
import com.sgic.hrm.leavesystem.entity.Leave;

public interface CalculateLieuLeaveService {
	boolean changeLieuLeaveCount(Leave leave, Integer id, Float update);	
}