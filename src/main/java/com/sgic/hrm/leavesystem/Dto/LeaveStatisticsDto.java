package com.sgic.hrm.leavesystem.Dto;

public class LeaveStatisticsDto {
	
	private Integer leaveTypeId;
	private String leaveType;
	private Integer allocationDays;
	private Integer remainingDays;
	
	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public Integer getAllocationDays() {
		return allocationDays;
	}
	public void setAllocationDays(Integer allocationDays) {
		this.allocationDays = allocationDays;
	}
	public Integer getRemainingDays() {
		return remainingDays;
	}
	public void setRemainingDays(Integer remainingDays) {
		this.remainingDays = remainingDays;
	}
	
	

}
