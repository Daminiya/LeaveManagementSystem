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
@Table(schema = "leave_system", name = "carry_forward")
public class CarryForward implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2113257986996510741L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;

	private Integer carryForwardDays;

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

	public Integer getCarryForwardDays() {
		return carryForwardDays;
	}

	public void setCarryForwardDays(Integer carryForwardDays) {
		this.carryForwardDays = carryForwardDays;
	}

}
