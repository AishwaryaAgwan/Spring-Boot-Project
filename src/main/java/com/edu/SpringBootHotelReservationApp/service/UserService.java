package com.edu.SpringBootHotelReservationApp.service;

import java.util.List;
import java.util.Optional;

import com.edu.SpringBootHotelReservationApp.entity.User;

public interface UserService {
	
	 public Optional<User> findUserByUserName(String userName);
	
	User saveUser(User user);
	List<User> getAllUser();
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);
	static List<User> getUserByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}
	static List<User> getUserByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	List<User> getUserByFirstNameOrLastName(String firstName, String lastName);
	List<User> getUserByFirstNameAndLastName(String firstName, String lastName);
	List<User> getUsersById(List<Long> idList);
	User getUserFullNameById(long id);
	List<User> getUserByHotelType();
	List<User> getUserInDescOrder();
}
