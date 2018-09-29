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
@Table(schema = "leave_system", name = "carry_forward_reject_reason")
public class CarryForwardRejectReason implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3666682031704670726L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Id
	private Integer carryForwardRequestId;
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "rejected_by")
	private User rejectedBy;
	
	private ZonedDateTime createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarryForwardRequestId() {
		return carryForwardRequestId;
	}

	public void setCarryForwardRequestId(Integer carryForwardRequestId) {
		this.carryForwardRequestId = carryForwardRequestId;
	}

	public User getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(User rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
