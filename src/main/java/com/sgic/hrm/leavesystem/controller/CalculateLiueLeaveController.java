package com.sgic.hrm.leavesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.service.CalculateLieuLeaveService;

@RestController
public class CalculateLiueLeaveController {

	@Autowired
	private CalculateLieuLeaveService calculateLieuLeaveService;

	@PutMapping("/changeLieuLeave")
	public HttpStatus changeLieuLeave(@RequestParam(value = "userId", required = false) Integer userId,
			@RequestParam(value = "leaveTypeId", required = false) Integer leaveTypeId,
			@RequestParam(value = "update", required = false) Float update) {

		if (userId == null || leaveTypeId == null || update == null) {
			return HttpStatus.BAD_REQUEST;
		} else {
			boolean test = calculateLieuLeaveService.changeLieuLeaveCount(userId, leaveTypeId, update);
			if (test) {
				return HttpStatus.ACCEPTED;
			}

		}
		return null;
	}

}
