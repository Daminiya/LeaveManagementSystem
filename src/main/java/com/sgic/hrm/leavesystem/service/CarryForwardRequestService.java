package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.CarryForwardRequest;

public interface CarryForwardRequestService {
	
	 boolean addCarryForwardRequest(CarryForwardRequest carryForwardRequest);
	 List<CarryForwardRequest> getAllCarryForwardRequests();
	 boolean editCarryForwardRequest(CarryForwardRequest carryForwardRequest, Integer id);
	 boolean deleteCarryForwardRequest(Integer id);
	 CarryForwardRequest getById(Integer id);
	 
	
	 
	 

}
