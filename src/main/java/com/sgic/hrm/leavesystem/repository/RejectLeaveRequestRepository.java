package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.leavesystem.entity.RejectLeaveRequest;

public interface RejectLeaveRequestRepository extends JpaRepository<RejectLeaveRequest, Integer>{
	

}
