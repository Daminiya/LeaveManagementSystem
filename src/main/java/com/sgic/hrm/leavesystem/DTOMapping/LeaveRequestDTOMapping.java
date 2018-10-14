package com.sgic.hrm.leavesystem.DTOMapping;

import com.sgic.hrm.leavesystem.entity.LeaveRequest;
import com.sgic.hrm.leavesystem.model.LeaveRequestDTO;

public class LeaveRequestDTOMapping {

	public static LeaveRequest LeaveRequestDTOToLeaveRequest(LeaveRequestDTO leaveRequestDTO) {
		
		LeaveRequest leaveRequest=new LeaveRequest();
		
		leaveRequest.setStartDate(leaveRequestDTO.getStartDate());
		leaveRequest.setEndDate(leaveRequestDTO.getEndDate());
		leaveRequest.setLeaveDays(leaveRequestDTO.getLeaveDays());
		leaveRequest.setReason(leaveRequestDTO.getReason());
		
		
		return leaveRequest;
		
	}
}
