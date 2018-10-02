package com.sgic.hrm.leavesystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.CarryForwardRequest;
import com.sgic.hrm.leavesystem.repository.CarryForwardRequestRepository;
import com.sgic.hrm.leavesystem.service.CarryForwardRequestService;

@Service
public class CarryForwardRequestServiceImpl implements CarryForwardRequestService{

	@Autowired
	CarryForwardRequestRepository carryForwardRequestRepository; 
	
	List<CarryForwardRequest> carryForwardRequestList=new ArrayList<>();
	
	@Override
	public boolean addCarryForwardRequest(CarryForwardRequest carryForwardRequest) {
		carryForwardRequestRepository.save(carryForwardRequest);
		return true;
	}

	@Override
	public List<CarryForwardRequest> getAllCarryForwardRequests() {
		carryForwardRequestList = carryForwardRequestRepository.findAll();
		return carryForwardRequestList;
	}

	@Override
	public boolean editCarryForwardRequest(CarryForwardRequest carryForwardRequest, Integer id) {
		
		boolean success = false;
		if(carryForwardRequestRepository.getOne(id) != null) {
			carryForwardRequestRepository.save(carryForwardRequest);
			success = true;
		}
		return success;
	}
	
	@Override
	public boolean deleteCarryForwardRequest(Integer id){
		
		if(carryForwardRequestRepository.getOne(id) != null){
			carryForwardRequestRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public CarryForwardRequest getById(Integer id) {
		return carryForwardRequestRepository.getOne(id);
	}



}
