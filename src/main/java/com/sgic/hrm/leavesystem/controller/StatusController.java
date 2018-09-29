package com.sgic.hrm.leavesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Status;
import com.sgic.hrm.leavesystem.service.StatusService;

@RestController
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/status")
	public Iterable<Status> getAllStatus(){
		return statusService.getAllStatus();
	}

}
