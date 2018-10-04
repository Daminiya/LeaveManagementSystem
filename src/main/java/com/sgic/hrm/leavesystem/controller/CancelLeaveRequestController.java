package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.CancelLeaveRequest;
import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.service.CancelLeaveRequestService;
import com.sgic.hrm.leavesystem.service.LeaveRequestService;
import com.sgic.hrm.leavesystem.service.LeaveService;

@RestController
public class CancelLeaveRequestController {

	@Autowired
	CancelLeaveRequestService cancelLeaveRequestService;
	@Autowired
	LeaveService leaveService;
	@Autowired
	LeaveRequestService leaveRequestService;

//view all the leave request function
	@GetMapping("/cancelLeaveRequest")
	public List<CancelLeaveRequest> getLeaveRequest() {
		return cancelLeaveRequestService.getLeaveRequest();
	}

//Cancel leave Request add function
	@PostMapping("/cancelLeaveRequest")
	public ResponseEntity<String> addCancelLeaveRequest(@RequestBody CancelLeaveRequest cancelLeaveRequest) {
		boolean success = cancelLeaveRequestService.addCancelLeaveRequest(cancelLeaveRequest);
		String result = "Add cancel request failed";
		ResponseEntity<String> status = new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
		if (success) {
			result = "Add cancel request sucessfully";
			status = new ResponseEntity<>(result, HttpStatus.OK);
		}
		return status;
	}

	// cancel leave request Approval done
	@PutMapping("/cancelLeaveRequest/{leaveRequestId}/{userId}/{statusId}")
	public ResponseEntity<String> editCancelRequestApproval(@PathVariable("leaveRequestId") int id,
			@PathVariable("userId") int userId, @PathVariable("statusId") int statusId) {
		boolean sucessStatus = leaveRequestService.editLeaveRequestStatus(id, statusId);
		boolean sucessCancelRequsetApproval = cancelLeaveRequestService.editCancelRequestApproval(id, userId);
		LeaveRequest leaveRequest = leaveRequestService.findLeaveRequestById(id);
		float sucessCancelRequestRemaindays = leaveService.increaseRemaingLeaveDays(leaveRequest.getLeaveDays(),
				leaveRequest.getUserId().getId(), leaveRequest.getLeaveTypeId().getId());
		String result = "Cancel requset approvel faild";
		ResponseEntity<String> status = new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
		if (sucessCancelRequsetApproval && sucessCancelRequestRemaindays >= 0 && sucessStatus) {
			result = "Cancel request approvel sucessfully";
			status = new ResponseEntity<>(result, HttpStatus.OK);
		}
		return status;
	}
}
