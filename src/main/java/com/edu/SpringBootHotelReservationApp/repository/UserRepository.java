package com.edu.SpringBootHotelReservationApp.repository;

import java.util.List;
import java.util.Optional;

//import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootHotelReservationApp.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findByUserName(String userName);
	
	List<User> findByLastName(String lastName);

	List<User> findByFirstNameOrLastName(String firstName, String lastName);

	List<User> findByFirstNameAndLastName(String firstName, String lastName);

	User findUserFullNameById(long id);

	List<User> findUsersByFirstName(String firstName);

	Optional<User> findByEmail(String string);
	
}

