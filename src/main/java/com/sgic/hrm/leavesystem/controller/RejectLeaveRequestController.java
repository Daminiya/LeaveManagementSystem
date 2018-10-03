package com.sgic.hrm.leavesystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.RejectLeaveRequest;
import com.sgic.hrm.leavesystem.service.RejectLeaveRequestService;

@RestController
public class RejectLeaveRequestController {

	@Autowired
	private RejectLeaveRequestService rejectLeaveRequestService;
	
	List<RejectLeaveRequest> rejectLeave=new ArrayList<>();	
	@PostMapping("/rejectleave")
	public boolean addRejectLeave(@RequestBody RejectLeaveRequest rejectLeaveRequest) {
		
		rejectLeaveRequestService.addRejectLeaveRequest(rejectLeaveRequest);
		return true;
	}
	
}
