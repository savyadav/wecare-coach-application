package com.carelifecoach.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;

import com.carelifecoach.dto.BookDTO;
import com.carelifecoach.entity.Book;
import com.carelifecoach.feignclients.CoachFeignCleint;
import com.carelifecoach.feignclients.UserFeignClient;
import com.carelifecoach.repository.BookRepository;
import com.carelifecoach.response.CoachResponse;
import com.carelifecoach.response.UserResponse;

public class BookService {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserFeignClient userFeignClient;
	
	@Autowired
	CoachFeignCleint coachFeignClient;
	public Boolean bookAppointment(Long userId, Long coachId, LocalDate appointmentDate, String slot) throws Exception {
	
		
			BookDTO bookingDTO = new BookDTO();
			bookingDTO.setAppointmentDate(appointmentDate);
			bookingDTO.setCoachId(coachId);
			bookingDTO.setSlot(slot);
			bookingDTO.setUserId(userId);
						
			Book bookingEntity = BookDTO.prepareEntity(bookingDTO);
			bookingEntity = bookRepository.saveAndFlush(bookingEntity);


			
			UserResponse userEntity = userFeignClient.getUserProfile(bookingDTO.getUserId());
			CoachResponse coachEntity = coachFeignClient.getCoachProfile(bookingDTO.getCoachId());
			
			String userName = userEntity.getName();
			String coachName = coachEntity.getName();
		
			String bookingSlot = bookingDTO.getSlot();
			LocalDate appointmentDate1 = bookingDTO.getAppointmentDate();
			Long bookingId = bookingEntity.getBookingId();
			
			
			return true;
		}
	public Boolean rescheduleAppointment(Long bookingId, LocalDate appointmentDate, String slot) throws Exception{
		BookDTO bookingDTO = findByBookingId(bookingId);
		if(bookingDTO==null)
			throw new Exception("BOOKING_DOESNOT_EXISTS");
		if(bookingDTO.getAppointmentDate().equals(appointmentDate) && bookingDTO.getSlot().equals(slot))
			throw new Exception("BOOKING_ALREADY_EXISTS");
		else {
			bookingDTO.setAppointmentDate(appointmentDate);
			bookingDTO.setSlot(slot);
			bookingDTO.setBookingId(bookingId);
			bookRepository.saveAndFlush(BookDTO.prepareEntity(bookingDTO));
			
			UserResponse user =userFeignClient.getUserProfile(bookingDTO.getUserId()) ;
			if(user.equals(null))
				throw new Exception("user.not.found");
			
			CoachResponse coach =coachFeignClient.getCoachProfile(bookingDTO.getCoachId()) ;
			if(user.equals(null))
				throw new Exception("user.not.found");
			
			
		
			
			return true;
		}
		
	}
	
	/*
	 * returns false if there is no booking with given bookingId
	 * returns true if successfully deleted
	 */
	public Boolean cancelAppointment(Long bookingId) throws Exception {
		BookDTO bookingDTO = findByBookingId(bookingId);
		if(bookingDTO==null)
			throw new Exception("BOOKING_DOESNOT_EXISTS");
		bookRepository.deleteById(bookingId);
	    return true;
	}
	
	
	public BookDTO findByBookingId(Long bookingId){
		Optional<Book> bookingEntity = bookRepository.findById(bookingId);
		if(bookingEntity.isPresent())
			return BookDTO.prepareDTO(bookingEntity.get());
		return null;
	}
	
	
	

}
