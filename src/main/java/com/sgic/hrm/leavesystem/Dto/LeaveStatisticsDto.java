package com.sgic.hrm.leavesystem.Dto;

public class LeaveStatisticsDto {
	
	private Integer leaveTypeId;
	private String leaveType;
	private Float allocationDays;
	private Float remainingDays;
	
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
	public Float getAllocationDays() {
		return allocationDays;
	}
	public void setAllocationDays(float f) {
		this.allocationDays = f;
	}
	public Float getRemainingDays() {
		return remainingDays;
	}
	public void setRemainingDays(Float remainingDays) {
		this.remainingDays = remainingDays;
	}
	
	

}
