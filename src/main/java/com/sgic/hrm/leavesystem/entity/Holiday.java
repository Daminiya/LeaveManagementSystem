package com.sgic.hrm.leavesystem.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "leave_system", name = "holiday")
public class Holiday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -660601087360209722L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;
	private ZonedDateTime holidayDate;
	private String reason;
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

	public ZonedDateTime getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(ZonedDateTime holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
