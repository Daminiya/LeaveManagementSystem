package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "leave")
public class Leave implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6124956867804468739L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@OneToOne
	@JoinColumn(name = "leave_type_id")
	private LeaveType leaveTypeId;

	private float remainDays;
	private float utilizedDays;

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

	public float getRemainDays() {
		return remainDays;
	}

	public void setRemainDays(float remainDays) {
		this.remainDays = remainDays;
	}

	public float getUtilizedDays() {
		return utilizedDays;
	}

	public void setUtilizedDays(float utilizedDays) {
		this.utilizedDays = utilizedDays;
	}

}
