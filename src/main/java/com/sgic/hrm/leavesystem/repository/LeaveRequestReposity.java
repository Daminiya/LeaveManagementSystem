/**
 * 
 */
package com.sgic.hrm.leavesystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.hrm.leavesystem.entity.LeaveRequest;

public interface LeaveRequestReposity extends JpaRepository<LeaveRequest, Integer> {

	// Code done by kowsikan
	LeaveRequest findById(int id);
}
