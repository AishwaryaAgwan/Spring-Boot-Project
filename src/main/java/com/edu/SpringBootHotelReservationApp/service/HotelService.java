package com.edu.SpringBootHotelReservationApp.service;

import java.util.List;

import com.edu.SpringBootHotelReservationApp.entity.Hotel;


public interface HotelService {
	
	Hotel saveHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	Hotel getHotelById(long id);
	Hotel updateHotel(Hotel hotel, long id);
	
	List<Hotel> getHotelsById(List<Long> id);

	List<Hotel> getHotelInDescOrder();

	void deleteHotel(long id);
	
	List<Hotel> getHotelByHotelName(String hotelName);


	List<Hotel> getHotelByLocation(String location);

	List<Hotel> getAllGallery();

	List<Hotel> getAllAbout();
}
