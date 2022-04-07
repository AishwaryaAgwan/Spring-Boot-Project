package com.edu.SpringBootHotelReservationApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootHotelReservationApp.entity.Booking;


public interface BookingRepository extends JpaRepository<Booking,Long> {

	

	List<Booking> findBookingByBookingDate(String bookingDate);

	List<Booking> findBookingByBookingTime(String bookingTime);

	

	List<Booking> findBookingByNumAdults(String numAdults);

	List<Booking> findBookingByNumChildren(String numChildren);




}
