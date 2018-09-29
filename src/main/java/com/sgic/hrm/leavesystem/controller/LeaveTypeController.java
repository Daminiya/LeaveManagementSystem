package com.sgic.hrm.leavesystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.LeaveType;
import com.sgic.hrm.leavesystem.service.LeaveTypeService;


@RestController
public class LeaveTypeController {
	
	@Autowired
	LeaveTypeService leaveTypeService;
	
	List<LeaveType> leavetype=new ArrayList<>();
	
	@PostMapping("/leavetype")
	public HttpStatus createLeave(@RequestBody LeaveType leavetype) {
		boolean res=leaveTypeService.addLeaveType(leavetype);
		if(res) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/leavetype")
		public ResponseEntity<List<LeaveType>> viewLeaveType() {
			List<LeaveType> leavetype = leaveTypeService.getLeaveType();
			ResponseEntity<List<LeaveType>> response = new ResponseEntity<>(leavetype, HttpStatus.OK);
			return response;
	}
	
	@PutMapping("/leavetype/{id}")
	public HttpStatus modifyLeaveType(@RequestBody LeaveType leavetype, @PathVariable Integer id) {
		boolean res=leaveTypeService.editLeaveType(leavetype, id);
		if(res) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/leavetype/{id}")
	public HttpStatus deleteUsers(@PathVariable Integer id) {
		boolean res=leaveTypeService.deleteLeaveType(id);
		if(res) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
}
