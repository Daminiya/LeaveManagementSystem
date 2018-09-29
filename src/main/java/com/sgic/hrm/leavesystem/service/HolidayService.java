package com.sgic.hrm.leavesystem.service;

import java.util.List;

import com.sgic.hrm.leavesystem.entity.Holiday;

public interface HolidayService {
	
	List<Holiday> getHoliday();
	Holiday getHolidayById(Integer id);
	boolean addHoliday(Holiday holiday);
	boolean modifyHoliday(Integer id, Holiday holiday);
	boolean deleteHoliday(Integer id);
}
