package com.sgic.hrm.leavesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.Dto.LeaveStatisticsDto;
import com.sgic.hrm.leavesystem.service.LeaveService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class LeaveController {
	@Autowired
	LeaveService leaveService;

	@GetMapping("/leave/{uid}/{lid}")
	public ResponseEntity<Float> findRemaingDays(@PathVariable("uid") int uid, @PathVariable("lid") int lid) {
		return new ResponseEntity<>(leaveService.findRemaingDays(uid, lid).getRemainDays(), HttpStatus.OK);
	}
	
	@GetMapping("/leave/{uid}")
	public ResponseEntity<Iterable<LeaveStatisticsDto>> findRemaingDays(@PathVariable("uid") int uid) {
	

		return new ResponseEntity<>(leaveService.findRemaingDays(uid), HttpStatus.OK);
	}

}
