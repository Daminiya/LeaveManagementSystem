package com.sgic.hrm.leavesystem.service;

public interface CalculateLieuLeaveService {
	boolean changeLieuLeaveCount(Integer userId , Integer leaveTypeId, Float update);
}