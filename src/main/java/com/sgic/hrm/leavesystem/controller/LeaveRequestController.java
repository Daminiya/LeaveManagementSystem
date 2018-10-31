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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.DTOMapping.LeaveRequestDTOMapping;
import com.sgic.hrm.leavesystem.Dto.LeaveRequestDto;
import com.sgic.hrm.leavesystem.Dto.LeaveRequestProcessDto;
import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.entity.RejectLeaveRequest;
import com.sgic.hrm.leavesystem.entity.User;
import com.sgic.hrm.leavesystem.service.LeaveRequestService;
import com.sgic.hrm.leavesystem.service.LeaveService;
import com.sgic.hrm.leavesystem.service.LeaveTypeService;
import com.sgic.hrm.leavesystem.service.RejectLeaveRequestService;
import com.sgic.hrm.leavesystem.service.StatusService;
import com.sgic.hrm.leavesystem.service.UserService;

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
	UserService userService;
	@Autowired
	LeaveTypeService leaveTypeService;
	@Autowired
	StatusService statusService;

	// Done by kowsikan
//	@PostMapping("/leaverequest")
//	public boolean addLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
//		// save record in leave request table
//		if (leaveRequestService.addLeaveRequest(leaveRequest)) {
//			leaveService.decreaseRemaingLeaveDays(leaveRequest.getLeaveDays(), leaveRequest.getUserId().getId(),
//					leaveRequest.getLeaveTypeId().getId());
//		}
//		return true;
//	}

	@PostMapping("/leaverequest")
	public boolean addLeaveRequestDTO(@RequestBody LeaveRequestDto leaveRequestDTO) {

		LeaveRequest leaveRequest = LeaveRequestDTOMapping.LeaveRequestDTOToLeaveRequest(leaveRequestDTO);

		leaveRequest.setUserId(userService.getUserById(leaveRequestDTO.getUserId()));
		leaveRequest.setLeaveTypeId(leaveTypeService.getLeaveTypeById(leaveRequestDTO.getLeaveTypeId()));
		leaveRequest.setStatusId(statusService.getStatusById(leaveRequestDTO.getStatusId()));

		leaveRequestService.addLeaveRequest(leaveRequest);
		// save record in leave request table
		if (leaveRequestService.addLeaveRequest(leaveRequest)) {

			leaveService.decreaseRemaingLeaveDays(leaveRequest.getLeaveDays(), leaveRequestDTO.getUserId(),
					leaveRequestDTO.getLeaveTypeId());
			return true;
		}

		return false;
	}

	@GetMapping("/leaveRequestModel")
	public LeaveRequestDto getMockLeaveRequestDTO() {
		LeaveRequestDto obj = new LeaveRequestDto();
		return obj;

	}
	
	@GetMapping("/leaveApprovedto")
	public LeaveRequestProcessDto getMockLeaveApproveDTO() {
		LeaveRequestProcessDto obj= new LeaveRequestProcessDto();
		return obj;

	}

	@GetMapping("/leaverequest")
	public List<LeaveRequest> getData() {
		return leaveRequestService.getData();
	}
	
	@GetMapping("/leaverequest/sort")
    public List<LeaveRequest> getDataBySort() {
        return leaveRequestService.getDataBySort();
    }

	// Bone by Pakikaran
	@DeleteMapping("/leaverequest/deleteRequest/{id}")
	public boolean deleteLeaveRequest(@PathVariable("id") int id) {
		LeaveRequest leaveRequest = leaveRequestService.findLeaveRequestById(id);
		leaveService.increaseRemaingLeaveDays(leaveRequest.getLeaveDays(), leaveRequest.getUserId().getId(),
				leaveRequest.getLeaveTypeId().getId());
		leaveRequestService.deleteLeaveRequest(id);

		return true;
	}

	// check the status below code illustrated ,done by thirupparan
	/*
	 * Set the Status Id:1 for approve leave request
	 */
//	@PostMapping("/leaverequest/{id}/{statusId}/{userId}")
//	public ResponseEntity<String> approveLeaveRequest(@PathVariable("id") int id, @PathVariable("statusId") int statusId,
//			@PathVariable("userId") int userId) {
//		boolean sucessStatus = leaveRequestService.editLeaveRequestStatus(id, statusId);
//		boolean successApproval = leaveRequestService.editLeaveRequestApproval(id, userId);
//		String result = "Status not changed";
//		ResponseEntity<String> status = new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
//		if (sucessStatus && successApproval) {
//			result = "Status changed sucessfully";
//			status = new ResponseEntity<>(result, HttpStatus.OK);
//		}
//		return status;
//
//	}
	
	@PostMapping("/leaverequest/leaveapprove")
	public HttpStatus approveLeaveRequest(@RequestBody LeaveRequestProcessDto lvRePrObj) {
		boolean sucessStatus = leaveRequestService.editLeaveRequestStatus(lvRePrObj.getLeaveRequestId(),lvRePrObj.getStatusId());
		boolean successApproval = leaveRequestService.editLeaveRequestApproval(lvRePrObj.getLeaveRequestId(), lvRePrObj.getProcessedBy());
	
		if (sucessStatus && successApproval) {
			return HttpStatus.CREATED;

		}

		return HttpStatus.BAD_REQUEST;

	}

	// check the status below code illustrated ,done by jerobert paki
	/*
	 * Set the Status Id:1 for approve leave request
	 */
	@PostMapping("/leaverequest/rejectleave")
	public HttpStatus addRejectLeave(@RequestBody LeaveRequestProcessDto lvRePrObj) {
		boolean rejectStatus = leaveRequestService.editLeaveRequestStatus(lvRePrObj.getLeaveRequestId(),lvRePrObj.getStatusId());
		boolean rejectBy = leaveRequestService.editLeaveRequestApproval(lvRePrObj.getLeaveRequestId(), lvRePrObj.getProcessedBy());
		
		LeaveRequest leaveRequest = leaveRequestService.findLeaveRequestById(lvRePrObj.getLeaveRequestId());
		leaveService.increaseRemaingLeaveDays(leaveRequest.getLeaveDays(), leaveRequest.getUserId().getId(),
				leaveRequest.getLeaveTypeId().getId());
		
		RejectLeaveRequest rejectLeaveRequest=new RejectLeaveRequest();
		rejectLeaveRequest.setLeaveRequestId(leaveRequest);
		User rejectByuser=userService.getUserById(lvRePrObj.getProcessedBy());
		rejectLeaveRequest.setRejectedBy(rejectByuser);
		rejectLeaveRequest.setRejectReason(lvRePrObj.getRejectreason());
		
		boolean saveRejectDetails=rejectLeaveRequestService.addRejectLeaveRequest(rejectLeaveRequest);
	
		
		if (rejectStatus && rejectBy && saveRejectDetails) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	// get details of leave request by user id
	@GetMapping("/leaverequest/user/{userId}")
	public ResponseEntity<List<LeaveRequest>> findLeaveRequestByUserId(@PathVariable("userId") Integer id) {		
		List<LeaveRequest> leaveRequsetDetails = leaveRequestService.findByUserId(id);
		return new ResponseEntity<>(leaveRequsetDetails, HttpStatus.OK);
	}

	// leave request details find by date
	@GetMapping("/leaverequest/{date}")
	public List<LeaveRequest> getDates(@PathVariable("date") @DateTimeFormat(iso = ISO.DATE_TIME) ZonedDateTime date) {
		return leaveRequestService.findByDate(date);
	}

}
