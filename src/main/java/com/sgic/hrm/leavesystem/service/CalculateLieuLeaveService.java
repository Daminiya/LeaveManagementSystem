package com.sgic.hrm.leavesystem.service;

public interface CalculateLieuLeaveService {
	boolean changeLieuLeaveCount(Integer userID , Integer leaveTypeId, Float update);
}