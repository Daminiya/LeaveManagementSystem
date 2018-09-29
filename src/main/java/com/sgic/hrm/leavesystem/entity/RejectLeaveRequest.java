package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "reject_leave_request")
public class RejectLeaveRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5027613028685981485L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "rejected_by")
	private User rejectedBy;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "leave_request_id")
	private LeaveRequest leaveRequestId;

	private String rejectReason;
	private ZonedDateTime createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(User rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public LeaveRequest getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(LeaveRequest leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
