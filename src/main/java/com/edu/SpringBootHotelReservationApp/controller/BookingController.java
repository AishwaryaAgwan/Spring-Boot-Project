package com.edu.SpringBootHotelReservationApp.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.SpringBootHotelReservationApp.entity.Booking;
import com.edu.SpringBootHotelReservationApp.service.BookingService;

@RestController
//@Controller
@RequestMapping("api/booking")
public class BookingController {
	private BookingService bookingService;
	
	
	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	
	@PostMapping
	public ResponseEntity<Booking>saveBooking(@RequestBody Booking booking){
		return new ResponseEntity<Booking>(bookingService.saveBooking(booking),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<Booking>getBookingById(@PathVariable("id")long id){
		return new ResponseEntity<Booking>(bookingService.getBookingById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Booking>updateBooking(@PathVariable("id")long id,@RequestBody Booking booking){
		return new ResponseEntity<Booking>(bookingService.updateBooking(booking,id),HttpStatus.OK);
	}
	

	@GetMapping("/bookingByBookingDate/{bookingDate}")
	public List<Booking>getBookingByBookingDate(@PathVariable("bookingDate")String bookingDate){
		return bookingService.getBookingByBookingDate(bookingDate);
	}

	@GetMapping("/bookingByBookingTime/{bookingTime}")
	public List<Booking>getBookingByBookingTime(@PathVariable("bookingTime")String bookingTime){
		return bookingService.getBookingByBookingTime(bookingTime);
	}
	@GetMapping("/bookingByNumAdults/{numAdults}")
	public List<Booking>getBookingByNumAdults(@PathVariable("numAdults")String numAdults){
		return bookingService.getBookingByNumAdults(numAdults);
	}
	@GetMapping("/bookingByNumChildren/{numChildren}")
	public List<Booking>getBookingByNumChildren(@PathVariable("numChildren")String numChildren){
		return bookingService.getBookingByNumChildren(numChildren);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteBooking(@PathVariable("id")long id){
		return new ResponseEntity<String>("Booking record deleted",HttpStatus.OK);
	}
	
	
	
}
