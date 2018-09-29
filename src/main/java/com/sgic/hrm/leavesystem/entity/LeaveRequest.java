package com.sgic.hrm.leavesystem.entity;

import java.io.File;
import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "leave_request")
public class LeaveRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5523585203299554529L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "user_id")
	private User userId;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "leave_type_id")
	private LeaveType leaveTypeId;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "status_id")
	private Status statusId;

	private ZonedDateTime startDate;
	private ZonedDateTime endDate;
	private String reason;
	private Float leaveDays;
	private File medicalReports;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "recommended_by")
	private User recommendedBy;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "approved_by")
	private User approvedBy;

	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public LeaveType getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(LeaveType leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

	public ZonedDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(ZonedDateTime startDate) {
		this.startDate = startDate;
	}

	public ZonedDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(ZonedDateTime endDate) {
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

	public User getRecommendedBy() {
		return recommendedBy;
	}

	public void setRecommendedBy(User recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
