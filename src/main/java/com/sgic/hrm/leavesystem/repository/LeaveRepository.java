package com.sgic.hrm.leavesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sgic.hrm.leavesystem.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer>{
	
	@Query("SELECT leave FROM Leave AS leave WHERE leave.user.id=?1")
	List<Leave> findLeaveByUserId(Integer id);

}
