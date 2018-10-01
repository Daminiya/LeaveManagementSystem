package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.CarryForward;
import com.sgic.hrm.leavesystem.repository.CarryForwardRepository;

@Service
public class CarryForwardImpl implements CarryForwardService {
	@Autowired
	CarryForwardRepository carryForwardRepository;

	@Override
	public boolean AddCarryForward(CarryForward carryForward) {
		carryForwardRepository.save(carryForward);
		return true;
	}

	@Override
	public List<CarryForward> ViewCarryForward() {
		
		return carryForwardRepository.findAll();
	}

}
