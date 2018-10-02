package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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
	@ManyToOne
	@JoinColumn(name = "carry_forward_request_id")
	private CarryForwardRequest carryForwardRequest;
	@ManyToOne
	@JoinColumn(name = "rejected_by")
	private User rejectedBy;
	private String rejectReason;
	@CreationTimestamp
	private ZonedDateTime createdAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CarryForwardRequest getCarryForwardRequest() {
		return carryForwardRequest;
	}
	public void setCarryForwardRequest(CarryForwardRequest carryForwardRequest) {
		this.carryForwardRequest = carryForwardRequest;
	}
	public User getRejectedBy() {
		return rejectedBy;
	}
	public void setRejectedBy(User rejectedBy) {
		this.rejectedBy = rejectedBy;
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
