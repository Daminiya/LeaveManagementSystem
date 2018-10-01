package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.leavesystem.entity.CancelLeaveRequest;

public interface CancelLeaveRequestRepository extends JpaRepository<CancelLeaveRequest, Integer>{

}
