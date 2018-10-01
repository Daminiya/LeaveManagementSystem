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

import com.sgic.hrm.leavesystem.entity.CarryForwardRequest;
import com.sgic.hrm.leavesystem.service.CarryForwardRequestService;

@RestController
public class CarryForwardRequestController {
	
	@Autowired
	CarryForwardRequestService carryForwardRequestService;

	
	@PostMapping("/carryforwardrequest")
	public HttpStatus createCarryForwardRequest(@RequestBody CarryForwardRequest carryForwardRequest) {
		boolean result = carryForwardRequestService.addCarryForwardRequest(carryForwardRequest);
		if(result) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/carryforwardrequest")
		public ResponseEntity<List<CarryForwardRequest>> viewCarryForwardRequest() {
			List<CarryForwardRequest> carryForwardRequest = carryForwardRequestService.getAllCarryForwardRequests();
			ResponseEntity<List<CarryForwardRequest>> response = new ResponseEntity<>(carryForwardRequest, HttpStatus.OK);
			return response;
	}
	
	@PutMapping("/carryforwardrequest/{id}")
	public HttpStatus modifyCarryForwardRequest(@RequestBody CarryForwardRequest carryForwardRequest, @PathVariable Integer id) {
		boolean result = carryForwardRequestService.editCarryForwardRequest(carryForwardRequest,id);
		if(result) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/carryforwardrequest/{id}")
	public HttpStatus deleteUsers(@PathVariable Integer id) {
		boolean result = carryForwardRequestService.deleteCarryForwardRequest(id);
		if(result) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
}
