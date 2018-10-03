package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.CarryForward;

public interface CarryForwardService {
	boolean AddCarryForward(CarryForward carryForward);

	List<CarryForward> ViewCarryForward();
}
