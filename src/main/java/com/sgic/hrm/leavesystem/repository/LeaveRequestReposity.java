/**
 * 
 */
package com.sgic.hrm.leavesystem.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.entity.User;

public interface LeaveRequestReposity extends JpaRepository<LeaveRequest, Integer> {

	// Code done by kowsikan
	LeaveRequest findById(int id);
	//get details of leave request by user id
	public Iterable<LeaveRequest>findByUserId(User id);

	// date wise pick the leave request records
	@Query("select lr from LeaveRequest as lr where lr.startDate <= ?1 AND lr.endDate >=?1")
	public List<LeaveRequest> findByDate(ZonedDateTime abc);
}
