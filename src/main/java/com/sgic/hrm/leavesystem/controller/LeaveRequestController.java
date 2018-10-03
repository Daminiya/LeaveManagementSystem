package com.sgic.hrm.leavesystem.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.entity.RejectLeaveRequest;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.service.LeaveRequestService;
import com.sgic.hrm.leavesystem.service.LeaveService;
import com.sgic.hrm.leavesystem.service.RejectLeaveRequestService;
import com.sgic.hrm.leavesystem.service.UserServices;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class LeaveRequestController {
	@Autowired
	LeaveRequestService leaveRequestService;
	@Autowired
	LeaveService leaveService;
	@Autowired
	RejectLeaveRequestService rejectLeaveRequestService;
	@Autowired
	UserServices userServices;

	// Done by kowsikan
	@PostMapping("/leaverequest")
	public boolean addLeaveRequest(@RequestBody LeaveRequest leaveRequestObj) {
		// save record in leave request table
		if (leaveRequestService.addLeaveRequest(leaveRequestObj)) {
			leaveService.decreaseRemaingLeaveDays(leaveRequestObj.getLeaveDays(), leaveRequestObj.getUserId().getId(),
					leaveRequestObj.getLeaveTypeId().getId());
		}
		// leaveService.decreaseRemaingLeaveDays(leaveRequestObj.getLeaveDays(), 1, 1);
		// return leaveRequestObj.getUserId().getId() + " " +
		// leaveRequestObj.getLeaveTypeId().getId();
		// System.out.println(leaveRequestObj.getLeaveDays());
		return true;
	}

	@GetMapping("/leaverequest")
	public List<LeaveRequest> getData() {
		return leaveRequestService.getData();
	}

	// Bone by Pakikaran
	@DeleteMapping("/leaverequest/deleteRequest/{id}")
	public boolean deleteLeaveRequest(@PathVariable("id") int id) {
		LeaveRequest leaveRequestObj = leaveRequestService.findLeaveRequestById(id);
		leaveService.increaseRemaingLeaveDays(leaveRequestObj.getLeaveDays(), leaveRequestObj.getUserId().getId(),
				leaveRequestObj.getLeaveTypeId().getId());
		leaveRequestService.deleteLeaveRequest(id);

		return true;
	}

	// check the status below code illustrated ,done by thirupparan
	/*
	 * Set the Status Id:1 for approve leave request
	 */
	@PutMapping("/leaverequest/{id}/{status}/{userId}")
	public ResponseEntity<String> approveLeaveRequest(@PathVariable("id") int id, @PathVariable("status") int statusId,
			@PathVariable("userId") int userId) {
		boolean sucessStatus = leaveRequestService.editLeaveRequestStatus(id, statusId);// can be hard coded
		boolean successApproval = leaveRequestService.editLeaveRequestApproval(id, userId);
		String result = "Status not show";
		ResponseEntity<String> status = new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
		if (sucessStatus && successApproval) {
			result = "Status sucessfully";
			status = new ResponseEntity<>(result, HttpStatus.OK);
		}
		return status;

	}

	// check the status below code illustrated ,done by jerobert paki
	/*
	 * Set the Status Id:1 for approve leave request
	 */
	@PutMapping("/leaverequest/rejectleave/{statusid}")
	public boolean addRejectLeave(@RequestBody RejectLeaveRequest rejectLeaveRequest,
			@PathVariable("id") int statusId) {
		// status id can be hard coded//
		leaveRequestService.editLeaveRequestStatus(rejectLeaveRequest.getLeaveRequestId().getId(), statusId);
		LeaveRequest leaveRequestObj = leaveRequestService
				.findLeaveRequestById(rejectLeaveRequest.getLeaveRequestId().getId());
		leaveService.increaseRemaingLeaveDays(leaveRequestObj.getLeaveDays(), leaveRequestObj.getUserId().getId(),
				leaveRequestObj.getLeaveTypeId().getId());
		rejectLeaveRequestService.addRejectLeaveRequest(rejectLeaveRequest);
		return true;
	}

	// get details of leave request by user id
	@GetMapping("/leaverequest/user/{userId}")
	public ResponseEntity<Iterable<LeaveRequest>> LeaveRequestFindByUserId(@PathVariable("userId") int id) {
		User userObj = userServices.findUserById(id);
		Iterable<LeaveRequest> leaveRequsetDetails = leaveRequestService.findByUserId(userObj);
		return new ResponseEntity<>(leaveRequsetDetails, HttpStatus.OK);
	}

	// leave request details find by date
	@GetMapping("/leaverequest/{date}")
	public List<LeaveRequest> getDates(@PathVariable("date") @DateTimeFormat(iso = ISO.DATE_TIME) ZonedDateTime abc) {

		return leaveRequestService.findByDate(abc);
	}

}
