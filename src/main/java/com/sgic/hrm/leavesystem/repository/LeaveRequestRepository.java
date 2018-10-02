package com.sgic.hrm.leavesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.hrm.leavesystem.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer>{
	
//	@Query("SELECT lr FROM LeaveRequest AS lr WHERE lr.user.id=?1 and lr.status.status=?2")
//	List<LeaveRequest> findLeaveRequestByUserId(Integer id, String status);
	
	
}
