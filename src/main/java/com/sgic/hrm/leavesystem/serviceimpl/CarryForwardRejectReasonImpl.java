package com.sgic.hrm.leavesystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.CarryForwardRejectReason;
import com.sgic.hrm.leavesystem.repository.CarryForwardRejectReasonRepository;
import com.sgic.hrm.leavesystem.service.CarryForwardRejectReasonService;
@Service
public class CarryForwardRejectReasonImpl implements CarryForwardRejectReasonService{
@Autowired
private CarryForwardRejectReasonRepository carryForwardRejectReasonRepository;
	@Override
	public boolean SaveCarryForwardRejectReason(CarryForwardRejectReason carryForwardRejectReasonEntity) {
		carryForwardRejectReasonRepository.save(carryForwardRejectReasonEntity);
		return true;
	}
	@Override
	public List<CarryForwardRejectReason> ViewAllCarryforward() {
		return carryForwardRejectReasonRepository.findAll();
		
	}

}
