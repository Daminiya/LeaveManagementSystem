package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.CarryForward;
import com.sgic.hrm.leavesystem.service.CarryForwardService;

@RestController
public class CarryForwardController {
	
	@Autowired
	CarryForwardService carryForwardService;

	@GetMapping("carryforward")
	public List<CarryForward> viewCarryForward() {
		return carryForwardService.viewCarryForward();

	}

	@PostMapping("carryforward")
	public boolean addCarryForward(@RequestBody CarryForward carryForward) {
		if (carryForward.getUserId() != null) {
			carryForwardService.addCarryForward(carryForward);
			return true;
		}
		return false;
	}
	
	@GetMapping("carryforwarddays/{id}")
	public Integer getCarryForwardDaysByUserId(@PathVariable Integer id) {
 		return carryForwardService.getCarryForwardDaysByUserId(id);
	}
}
