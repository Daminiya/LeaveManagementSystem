package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Leave;
import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.repository.LeaveRepository;
import com.sgic.hrm.leavesystem.service.LeaveRequestService;
import com.sgic.hrm.leavesystem.service.LeaveService;

@RestController
public class LeaveRequestController {
	@Autowired
	LeaveRequestService leaveRequestService;
	@Autowired
	LeaveService leaveService;
	@Autowired
	LeaveRepository leaveRepo;

	// Done by kowsikan
	@PostMapping("/leaverequest")
	public String addLeaveRequest(@RequestBody LeaveRequest leaveRequestObj) {
		// save record in leave request table
		if (leaveRequestService.addLeaveRequest(leaveRequestObj)) {
			leaveService.decreaseRemaingLeaveDays(leaveRequestObj.getLeaveDays(), leaveRequestObj.getUserId().getId(),
					leaveRequestObj.getLeaveTypeId().getId());
		}

		// leaveService.decreaseRemaingLeaveDays(leaveRequestObj.getLeaveDays(), 1, 1);
		return leaveRequestObj.getUserId().getId() + " " + leaveRequestObj.getLeaveTypeId().getId();
	}

	@GetMapping("/leaverequest")
	public List<LeaveRequest> getData() {
		return leaveRequestService.getData();
	}

	// Bone by Pakikaran
	@DeleteMapping("/leaverequest/{id}")
	public boolean deleteLeaveRequest(@PathVariable("id") int id) {
		LeaveRequest leaveRequestObj = leaveRequestService.findLeaveRequestById(id);

		leaveService.increaseRemaingLeaveDays(leaveRequestObj.getLeaveDays(), leaveRequestObj.getUserId().getId(),
				leaveRequestObj.getLeaveTypeId().getId());
		leaveRequestService.deleteLeaveRequest(id);

		return true;
	}

	// Test methods goes here
	@GetMapping("/leaverequest/testreq1")
	public float test1() {
		return leaveService.increaseRemaingLeaveDays(5, 1, 1);
	}

	@GetMapping("/leaverequest/testreq2")
	public float test2() {
		return leaveService.decreaseRemaingLeaveDays(8, 1, 1);
	}

	@GetMapping("/leaverequest/testleave")
	public Leave test3() {
		return leaveRepo.findRemaingDaysByUserIdAndLeaveTypeId(1, 1);
	}

}
