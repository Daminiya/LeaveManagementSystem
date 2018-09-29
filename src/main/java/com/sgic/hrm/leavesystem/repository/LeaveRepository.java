package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sgic.hrm.leavesystem.entity.Leave;


public interface LeaveRepository extends JpaRepository<Leave,Integer> {

	
	
// Code done by jerobert
	
    //@Query("SELECT t.remain_days FROM leave_system.leave t where t.user_id = ?1 AND t.leave_type_id=?2") 
	@Query("select l from Leave as l where l.userId.id = ?1 and l.leaveTypeId.id = ?2")
    Leave findRemaingDaysByUserIdAndLeaveTypeId(int uid,int lid);
	
	
}
