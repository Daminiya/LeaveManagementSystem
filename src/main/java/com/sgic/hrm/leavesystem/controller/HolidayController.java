package com.sgic.hrm.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.leavesystem.entity.Holiday;
import com.sgic.hrm.leavesystem.service.HolidayService;

@RestController
public class HolidayController {

	@Autowired
	HolidayService holidayService;
	
	@GetMapping("/holiday")
	public List<Holiday> geHoliday() {
		return holidayService.getHoliday();
	}
	
	@GetMapping("/holiday/by")
	public Holiday getHolidayById(@RequestParam(value="id", required=true) Integer id) {
		if (null != holidayService.getHolidayById(id)) {
		return holidayService.getHolidayById(id);
		} else {
		return null;
		}
	}
	
	@PostMapping("/holiday")
	public HttpStatus addHoliday(@RequestBody Holiday holiday) {
		boolean addStatus = holidayService.addHoliday(holiday);
		if (addStatus) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("/holiday/{id}")
	public HttpStatus modifyHoliday(@PathVariable("id") Integer id, @RequestBody Holiday holiday) {
		boolean addStatus = holidayService.modifyHoliday(id, holiday);
		if (addStatus) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/holiday/{id}")
	public HttpStatus deleteHoliday(@PathVariable("id") Integer id) {
		boolean addStatus = holidayService.deleteHoliday(id);
		if (addStatus) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
