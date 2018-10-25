package com.sgic.hrm.leavesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Status;
import com.sgic.hrm.leavesystem.service.StatusService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class StatusController {

	@Autowired
	private StatusService statusService;

	@GetMapping("/status")
	public Iterable<Status> getAllStatus() {
		return statusService.getAllStatus();
	}

	@PostMapping("/status")
	public boolean save(@RequestBody Status status) {
		statusService.save(status);
		return true;
	}

	@DeleteMapping("/status/{id}")
	public boolean delete(@PathVariable("id") int id) {
		statusService.delete(id);
		return true;

	}
	@PutMapping("/status/{id}")
	public HttpStatus ModifyStatus(@PathVariable Integer id,@RequestBody Status status) {
		boolean test = statusService.editStatus(status, id);
		if (test) {
		return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;

		}
}
