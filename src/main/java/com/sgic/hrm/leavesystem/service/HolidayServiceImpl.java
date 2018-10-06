package com.sgic.hrm.leavesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.leavesystem.entity.Holiday;
import com.sgic.hrm.leavesystem.repository.HolidayRepository;

@Service
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	HolidayRepository holidayRipo;

	@Override
	public List<Holiday> getHoliday() {
		return holidayRipo.findAll();
	}

	@Override
	public Holiday getHolidayById(Integer id) {
		if (null != holidayRipo.getOne(id)) {
			return holidayRipo.getOne(id);
		}
		return null;
	}

	@Override
	public boolean addHoliday(Holiday holiday) {
		if (holiday != null) {
			holidayRipo.save(holiday);
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyHoliday(Integer id, Holiday holiday) {
		if (holidayRipo.getOne(id) != null && id == holiday.getId()) {
			holidayRipo.save(holiday);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteHoliday(Integer id) {
		if (null != holidayRipo.getOne(id)) {
			holidayRipo.deleteById(id);
			return true;
		}
		return false;
	}

}
