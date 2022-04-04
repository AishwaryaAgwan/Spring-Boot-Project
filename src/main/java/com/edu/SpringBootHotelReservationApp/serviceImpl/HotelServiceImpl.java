package com.edu.SpringBootHotelReservationApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootHotelReservationApp.entity.Hotel;
import com.edu.SpringBootHotelReservationApp.exception.ResourceNotFoundException;
import com.edu.SpringBootHotelReservationApp.repository.HotelRepository;
import com.edu.SpringBootHotelReservationApp.service.HotelService;


@Service
public  class HotelServiceImpl implements HotelService{

	private HotelRepository hotelRepository;
	
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}


	@Override
	public  Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}


	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
		
	}


	@Override
	public Hotel getHotelById(long id) {
		Optional<Hotel> hotel = hotelRepository.findById(id);
		if(hotel.isPresent()) {
			return hotel.get();
		}
		else {
          
			throw new ResourceNotFoundException("Hotel","Id",id);
		}
		
	}


	@Override
	public Hotel updateHotel(Hotel hotel, long id) {
		Hotel hotel1 = new Hotel();
	 try {
		   hotel = hotelRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFoundException("Hotel","Id",id));
	} catch (ResourceNotFoundException e) {
		
		e.printStackTrace();
	}
	hotel1.setHotelName(hotel.getHotelName());
	hotel1.setLocation(hotel.getLocation());
	hotel1.setType(hotel.getType());
	//hotel1.set(hotel1.getPrice());
	hotel1.setDescription(hotel.getDescription());
	
	hotelRepository.save(hotel1);
	return hotel1;
	}


	public HotelRepository getEmployeeRepository() {
		return hotelRepository;
	}


	public void setHotelRepository(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}


	@Override
	public List<Hotel> getHotelByHotelName(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Hotel> getHotelByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getHotelsById(List<Long> id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Hotel> getHotelInDescOrder() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteHotel(long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Hotel> getAllGallery() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Hotel> getAllAbout() {
		// TODO Auto-generated method stub
		return null;
	}


	/*@Override
	public List<Hotel> getHotelByHotelName(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Hotel> getHotelByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}
*/





	

}
