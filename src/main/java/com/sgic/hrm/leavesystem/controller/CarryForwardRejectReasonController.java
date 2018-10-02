package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.CarryForwardRejectReason;
import com.sgic.hrm.leavesystem.service.CarryForwardRejectReasonService;

@RestController
public class CarryForwardRejectReasonController {
	@Autowired
	private CarryForwardRejectReasonService carryForwardRejectReasonService;
	
	@PostMapping("/carryForwardRejectReason")
	public boolean UpdateCarryForwardReason(@RequestBody CarryForwardRejectReason carryForwardRejectReasonEntity) {
		carryForwardRejectReasonService.SaveCarryForwardRejectReason(carryForwardRejectReasonEntity);
		return true;
	}
	
	@GetMapping("/carryForwardRejectReason")
	public List<CarryForwardRejectReason> FindAll(){
		return carryForwardRejectReasonService.ViewAllCarryforward();
	}
}
