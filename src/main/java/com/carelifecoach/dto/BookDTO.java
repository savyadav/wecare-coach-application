package com.carelifecoach.dto;

import java.time.LocalDate;

import com.carelifecoach.entity.Book;

public class BookDTO {
	Long	bookingId;

	Long userId;

	Long coachId;

	LocalDate appointmentDate;
	 
	String slot;



	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
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
	
	public static BookDTO prepareDTO(Book bookingEntity) {
		BookDTO bookingDTO = new BookDTO();
		bookingDTO.setAppointmentDate(bookingEntity.getAppointmentDate());
		bookingDTO.setBookingId(bookingEntity.getBookingId());
		bookingDTO.setCoachId(bookingEntity.getCoachId());
		bookingDTO.setSlot(bookingEntity.getSlot());
		bookingDTO.setUserId(bookingEntity.getUserId());
		return bookingDTO;
	}

	public static Book prepareEntity(BookDTO bookingDTO) {
		Book bookingEntity = new Book();
		bookingEntity.setAppointmentDate(bookingDTO.getAppointmentDate());
		bookingEntity.setBookingId(bookingDTO.getBookingId());
		bookingEntity.setCoachId(bookingDTO.getCoachId());
		bookingEntity.setSlot(bookingDTO.getSlot());
		bookingEntity.setUserId(bookingDTO.getUserId());
		return bookingEntity;
	}

	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", userId=" + userId + ", coachId=" + coachId
				+ ", appointmentDate=" + appointmentDate + ", slot=" + slot + "]";
	}

}