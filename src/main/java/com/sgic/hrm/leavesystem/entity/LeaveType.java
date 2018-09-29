package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "leave_type")
public class LeaveType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2769878842031112400L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String leaveType;
	private float allocationDays;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public float getAllocationDays() {
		return allocationDays;
	}

	public void setAllocationDays(float allocationDays) {
		this.allocationDays = allocationDays;
	}

}
