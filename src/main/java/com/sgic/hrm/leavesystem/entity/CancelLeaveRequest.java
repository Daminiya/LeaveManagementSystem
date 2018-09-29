package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "cancel_leave_request")
public class CancelLeaveRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 107386259721142689L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "leave_request_id")
	private LeaveRequest leaveRequestId;

	private String cancelReason;
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "cancelled_by")
	private User cancelledBy;

	private ZonedDateTime createAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LeaveRequest getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(LeaveRequest leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public User getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(User cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	public ZonedDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(ZonedDateTime createAt) {
		this.createAt = createAt;
	}

}
