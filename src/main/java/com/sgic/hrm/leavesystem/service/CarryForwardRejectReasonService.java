package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.CarryForwardRejectReason;

public interface CarryForwardRejectReasonService {
	public boolean SaveCarryForwardRejectReason(CarryForwardRejectReason carryForwardRejectReasonEntity);
	public List<CarryForwardRejectReason> ViewAllCarryforward();
}
