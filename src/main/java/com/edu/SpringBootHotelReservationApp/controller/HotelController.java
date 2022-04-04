package com.edu.SpringBootHotelReservationApp.controller;

import java.util.List;

//import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootHotelReservationApp.entity.Hotel;
import com.edu.SpringBootHotelReservationApp.service.HotelService;

@RestController
@RequestMapping("/api/hotel")// url

public class HotelController {
	private HotelService hotelService;

	public HotelController( HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}
	
	@PostMapping
	// saveHotel(User obj)
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
		return new ResponseEntity<Hotel>(hotelService.saveHotel(hotel),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Hotel> getAllHotel()
	{
		return hotelService.getAllHotel();
	}
	
	@GetMapping("{id}")//4
	public ResponseEntity<Hotel>getHotelById(@PathVariable("id") long id) {
		return new ResponseEntity<Hotel>(hotelService.getHotelById(id), HttpStatus.OK);
	}
	
	@GetMapping("/hotelByHotelName/{hotelName}")//john
	public List<Hotel> getHotelByHotelName(@PathVariable("hotelName")String hotelName){
		return hotelService.getHotelByHotelName(hotelName);//john
	}
	
	@GetMapping("/hotelByLocation/{location}")//doe
	public List<Hotel> getHotelByLocation(@PathVariable("location") String location){
		return hotelService.getHotelByLocation(location);//deo
		
	}
	

	
	@GetMapping("/hotelByIds")
	public List<Hotel> getHotelsByIds(@RequestParam(value="id") List<Long> id){
		return  hotelService.getHotelsById(id);
	}
	
	
		@PutMapping("{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable("id") long id, @RequestBody Hotel hotel){
		
		return new ResponseEntity<Hotel>(hotelService.updateHotel(hotel, id),HttpStatus.OK);
		
	}
		
	@GetMapping("/hotelInDescOrder")
	public List<Hotel> getHotelInDescOrder(){
		return hotelService.getHotelInDescOrder();
	}

	// CRUD
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable("id") long id){
		hotelService.deleteHotel(id);
		return new ResponseEntity<String>("Hotel record deleted ",HttpStatus.OK);
		
	}
	
	
	
	
}
