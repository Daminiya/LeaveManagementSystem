package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.leavesystem.entity.CancelLeaveRequest;
import com.sgic.hrm.leavesystem.entity.LeaveRequest;

public interface CancelLeaveRequestRepository extends JpaRepository<CancelLeaveRequest, Integer> {
	CancelLeaveRequest findByLeaveRequestId(LeaveRequest id);
}
