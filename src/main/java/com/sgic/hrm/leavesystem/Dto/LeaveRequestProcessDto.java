package com.sgic.hrm.leavesystem.Dto;

public class LeaveRequestProcessDto {
	private Integer statusId;
	private Integer leaveRequestId;
	private Integer processedBy;
	private String rejectreason;
	
	public String getRejectreason() {
		return rejectreason;
	}
	public void setRejectreason(String rejectreason) {
		this.rejectreason = rejectreason;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getLeaveRequestId() {
		return leaveRequestId;
	}
	public void setLeaveRequestId(Integer leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}
	public Integer getProcessedBy() {
		return processedBy;
	}
	public void setProcessedBy(Integer processedBy) {
		this.processedBy = processedBy;
	}
	

}
