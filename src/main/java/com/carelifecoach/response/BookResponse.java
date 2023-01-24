package com.carelifecoach.response;

import java.time.LocalDate;

public class BookResponse {
	private long bookingId;
	private Long userId;

	private Long coachId;

	private LocalDate appointmentDate;
	 
	private String slot;
	private UserResponse userResponse;
	
	private CoachResponse coachResponse;
	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCoachId() {
		return coachId;
	}

	public void setCoachId(Long coachId) {
		this.coachId = coachId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public UserResponse getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}

	public CoachResponse getCoachResponse() {
		return coachResponse;
	}

	public void setCoachResponse(CoachResponse coachResponse) {
		this.coachResponse = coachResponse;
	}
	

}
