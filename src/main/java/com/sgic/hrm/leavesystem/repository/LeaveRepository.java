
package com.sgic.hrm.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.sgic.hrm.leavesystem.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	@Query("SELECT lv FROM Leave as lv WHERE lv.userId.id=?1 AND lv.leaveTypeId.id=?2 ")
	Leave getLeaveById(Integer userId, Integer leaveId);

	@Transactional
	@Modifying
	@Query("UPDATE Leave as lv SET lv.remainDays = ?1 WHERE lv.id = ?2 ")
	void setRemainDays(Float update, Integer id);

}
