package com.sgic.hrm.leavesystem.DTOMapping;

import com.sgic.hrm.leavesystem.Dto.LeaveRequestDto;
import com.sgic.hrm.leavesystem.entity.LeaveRequest;


public class LeaveRequestDTOMapping {

	public static LeaveRequest LeaveRequestDTOToLeaveRequest(LeaveRequestDto leaveRequestDTO) {
		
		LeaveRequest leaveRequest=new LeaveRequest();
		
		leaveRequest.setStartDate(leaveRequestDTO.getStartDate());
		leaveRequest.setEndDate(leaveRequestDTO.getEndDate());
		leaveRequest.setLeaveDays(leaveRequestDTO.getLeaveDays());
		leaveRequest.setReason(leaveRequestDTO.getReason());
		
		
		return leaveRequest;
		
	}
}
