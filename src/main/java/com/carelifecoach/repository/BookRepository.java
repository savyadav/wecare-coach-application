package com.carelifecoach.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carelifecoach.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	
	//This method is used to find list of bookings using given user id which are after current date.
	@Query(value = "select b from booking b where b.userId=?1 and b.appointmentDate>?2")
	List<Book> findBookingByUserId(String userId, LocalDate today);
	
	//This method is used to find list of bookings using given coach id which are after current date.
	@Query(value = "select b from booking b where b.coachId=?1 and b.appointmentDate>?2")
	List<Book> findBookingByCoachId(String coachId, LocalDate today);
}