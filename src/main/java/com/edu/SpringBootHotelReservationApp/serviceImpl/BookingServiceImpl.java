package com.edu.SpringBootHotelReservationApp.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootHotelReservationApp.entity.Booking;
import com.edu.SpringBootHotelReservationApp.exception.ResourceNotFoundException;
import com.edu.SpringBootHotelReservationApp.repository.BookingRepository;
import com.edu.SpringBootHotelReservationApp.service.BookingService;


@Service
public class BookingServiceImpl  implements BookingService{
	
	private BookingRepository bookingRepository;
	
	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}


	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	
	@Override
	public List<Booking>getAllBooking(){
		return bookingRepository.findAll();
	}
	
	@Override
	public Booking getBookingById(long id) {
		Optional<Booking>booking = bookingRepository.findById(id);
		if(booking.isPresent()) {
			return booking.get();
		}
		else {
			throw new ResourceNotFoundException("Booking","Id",id);
			
		}
	}

	@Override
	public Booking updateBooking(Booking booking,long id) {
		Booking book = new Booking();
		try {
			book = bookingRepository.findById(id).orElseThrow(   ()->  new ResourceNotFoundException("Booking","Id",id));
		} catch(ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		book.setBookingDate(booking.getBookingDate());
		book.setBookingTime(booking.getBookingTime());
		book.setNumAdults(booking.getNumAdults());
		book.setNumChildren(booking.getNumChildren());
		bookingRepository.save(book);
		return book;
		

}

	@Override
	public List<Booking> getBookingByBookingDate(String bookingDate) {
		return bookingRepository.findBookingByBookingDate(bookingDate);
	}

	@Override
	public List<Booking> getBookingByBookingTime(String bookingTime) {
		return bookingRepository.findBookingByBookingTime(bookingTime);
	}

	
	@Override
	public List<Booking> getBookingByNumAdults(String numAdults) {
		return bookingRepository.findBookingByNumAdults(numAdults);
	}

	@Override
	public List<Booking> getBookingByNumChildren(String numChildren) {
		return bookingRepository.findBookingByNumChildren(numChildren);
	}


	@Override
	public void deleteBooking(long id) {
		// TODO Auto-generated method stub
		
	}

/*
	@Override
	public List<Booking> getAllbooking(String booking) {
		return bookingRepository.findBookingByBookingDate(booking);
	}

*/
	


	
	

	
	
	
}
