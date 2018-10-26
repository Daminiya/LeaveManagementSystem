
package com.sgic.hrm.leavesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.sgic.hrm.leavesystem.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	@Query("SELECT lv FROM Leave as lv WHERE lv.userId.id=?1 AND lv.leaveTypeId.id=?2 ")
	Leave getLeaveById(Integer userId, Integer leaveId);

	@Query("SELECT lv FROM Leave as lv WHERE lv.userId.id=?1")
	List<Leave> getLeaveByUserId(Integer userId);

	@Transactional
	@Modifying
	@Query("UPDATE Leave as lv SET lv.remainDays = ?1 WHERE lv.id = ?2 ")
	void setRemainDays(Float update, Integer id);

// Code done by jerobert
	@Query("select l from Leave as l where l.userId.id = ?1 and l.leaveTypeId.id = ?2")
	Leave findRemaingDaysByUserIdAndLeaveTypeId(int uid, int lid);
	
//	@Query("select l.leaveTypeId.id,l.remainDays,l.leaveTypeId.leaveType,l.leaveTypeId.allocationDays from Leave as l where l.userId.id = ?1")
//	List<Leave> findByUserId(Integer uid);
	
//	@Query("select l.leaveTypeId,l.remainDays from Leave as l where l.userId.id = ?1")
//	Iterable<Leave> findByUserId(Integer uid);
	
	@Query("select l from Leave as l where l.userId.id = ?1")
	Iterable<Leave> findByUserId(Integer uid);

	
	
}
