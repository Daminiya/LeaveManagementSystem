/**
 * 
 */
package com.sgic.hrm.leavesystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.entity.User;

public interface LeaveRequestReposity extends JpaRepository<LeaveRequest, Integer> {

	// Code done by kowsikan
	LeaveRequest findById(int id);
	//get details of leave request by user id
	public Iterable<LeaveRequest>findByUserId(User id);
}
