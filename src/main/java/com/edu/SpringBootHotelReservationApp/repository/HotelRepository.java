package com.edu.SpringBootHotelReservationApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootHotelReservationApp.entity.Hotel;
import com.edu.SpringBootHotelReservationApp.entity.User;

public interface HotelRepository extends JpaRepository<Hotel,Long>{

	User findUserFullNameById(long id);
	
	List<Hotel> getHotelByHotelName(String hotelName);
	
	List<Hotel> getHotelByLocation(String location);

	Hotel save(Hotel hotel);

	//Hotel save();

	Optional<Hotel> findBytype(String string);
};