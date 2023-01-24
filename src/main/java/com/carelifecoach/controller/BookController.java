package com.carelifecoach.controller;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.carelifecoach.dto.BookDTO;
import com.carelifecoach.service.BookService;

public class BookController {
	@Autowired
	BookService bookService;
		
	@PostMapping("/users/{userId}/booking/{coachId}")
	public ResponseEntity<Boolean> bookAppointment(@PathVariable Long userId,@PathVariable Long coachId, @RequestBody BookDTO bookingDTO ) throws Exception{
		String slot = bookingDTO.getSlot();
		LocalDate dateOfAppointment = bookingDTO.getAppointmentDate();
		Boolean response = bookService.bookAppointment(userId, coachId, dateOfAppointment, slot);
		if(response.booleanValue())
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	} 
	
	@PutMapping("/booking/{bookingId}")
	public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable Long bookingId, @RequestBody BookDTO bookingDTO) throws Exception{
		LocalDate dateOfAppointment = bookingDTO.getAppointmentDate();
		String slot = bookingDTO.getSlot();
		Boolean response = bookService.rescheduleAppointment(bookingId, dateOfAppointment, slot);
		if(response.booleanValue())
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/booking/{bookingId}")
	public ResponseEntity<Boolean> cancelAppointment(@PathVariable Long bookingId) throws Exception{
		Boolean response = bookService.cancelAppointment(bookingId);
		return ResponseEntity.ok(response);
	}
}
