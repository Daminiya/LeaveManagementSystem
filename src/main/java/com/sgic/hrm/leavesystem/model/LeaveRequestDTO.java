package com.sgic.hrm.leavesystem.model;

import java.io.File;
import java.util.Date;

public class LeaveRequestDTO {

	// leave request
	private Integer id;
	private Integer userId;
	private Integer leaveTypeId;
	private Date startDate;
	private Date endDate;
	private String reason;
	private Float leaveDays;
	private File medicalReports;

	// leave Approval
	private Integer statusId = null;
	private Integer recommendedBy = null;
	private Integer approvedBy = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Float getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(Float leaveDays) {
		this.leaveDays = leaveDays;
	}

	public File getMedicalReports() {
		return medicalReports;
	}

	public void setMedicalReports(File medicalReports) {
		this.medicalReports = medicalReports;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getRecommendedBy() {
		return recommendedBy;
	}

	public void setRecommendedBy(Integer recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

	public Integer getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

}
