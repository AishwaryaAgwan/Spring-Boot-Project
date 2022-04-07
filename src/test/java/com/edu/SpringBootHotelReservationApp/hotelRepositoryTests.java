package com.edu.SpringBootHotelReservationApp;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.SpringBootHotelReservationApp.entity.Hotel;
import com.edu.SpringBootHotelReservationApp.repository.HotelRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class hotelRepositoryTests {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Test
	@Rollback(false)

    public void saveHotelTest() {
		Hotel hotel = hotelRepository.save(new Hotel("Sun&Sun","Shirdi","five star","very famous hotel"));
    	
    		Assertions.assertThat(hotel.getId()).isGreaterThan(0);
    	
    }
	
	@Test
	public void getHotelTest() {
		Hotel hotel = hotelRepository.findById(9L).get();
		Assertions.assertThat(hotel.getId()).isEqualTo(9L);

	}
	
	@Test
	public void getHotelListTest() {
		List<Hotel> hotels = hotelRepository.findAll();
		Assertions.assertThat(hotels.size()).isGreaterThan(0);

	}
	
	@Test
	public void updateHotelTest() {
		Hotel hotel = hotelRepository.findById(9L).get();
		hotel.setType("five star");
		Hotel updated = hotelRepository.save(hotel); 
		Assertions.assertThat(hotel.getType()).isEqualTo("five star");

		
	}
	
	@Test
	public void deleteUserTest() {

		Hotel ho = hotelRepository.findById(9L).get();
		hotelRepository.delete(ho);
		Hotel hotel=null;
		Optional<Hotel> ho1 = hotelRepository.findBytype("five star");
		if(ho1.isPresent()) {
			hotel = ho1.get();
		}
		
		Assertions.assertThat(hotel).isNull();
		
	}
}