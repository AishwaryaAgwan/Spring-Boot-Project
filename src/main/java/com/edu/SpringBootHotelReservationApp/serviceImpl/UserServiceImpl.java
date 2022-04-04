package com.edu.SpringBootHotelReservationApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootHotelReservationApp.entity.User;
import com.edu.SpringBootHotelReservationApp.exception.ResourceNotFoundException;
import com.edu.SpringBootHotelReservationApp.repository.UserRepository;
import com.edu.SpringBootHotelReservationApp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
//public abstract class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
		
	}
// 4 - >Employee employee = {"john", "deo"}
// 12 - >Employee employee =  null
	@Override
	public User getUserById(long id) {//4
		Optional<User> user = userRepository.findById(id);//4
		if(user.isPresent()) {
			return user.get();
		}
		else {
          
			throw new ResourceNotFoundException("User","Id",id);
		}
		
	}


	@Override
	public User updateUser(User user, long id) {
		User use = new User();
	 try {
		 //orElseThrow();
		   use = userRepository.findById(id).orElseThrow(//4
				 ()-> 		 new ResourceNotFoundException("User","Id",id));
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  String fname = user.getFirstName();
	 use.setFirstName(fname);// a(emp)  - > A(employee)
	 
	 use.setLastName(user.getLastName());
	 use.setEmail(use.getEmail());
	 
	userRepository.save(use);
	return use;
	}


	@Override
	public void deleteUser(long id) {//13
		userRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("User","Id",id));
		
		userRepository.deleteById(id);//13
		
	}
	
	
	public List<User> getUserByFirstName(String firstName) {//john
				return userRepository.findUsersByFirstName(firstName);
	}


	public List<User> getUserByLastName(String lastName) {// deo
		return userRepository.findByLastName(lastName);
		
	}


	/*@Override
	public List<Employee> getEmployeesByIds(List<Long> idList) {
		return employeeRepository.findEmployeesByIds(idList);
	}*/


	
	@Override
	public List<User> getUserByFirstNameOrLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameOrLastName(firstName, lastName);
	}

// select * from employeeTbl where first_name="john" ANd last_name="doe"
	@Override
	public List<User> getUserByFirstNameAndLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}


	@Override
	public List<User> getUsersById(List<Long> idList) {
		
		return null;//employeeRepository.findEmployeesById(idList);
	}


	/*@Override
	public List<Employee> getEmployeeByDepartment(long id) {
		return employeeRepository.findByDepartmentId(id);
	}*/


	@Override
	public User getUserFullNameById(long id) {
		return userRepository.findUserFullNameById(id);
	}


//	@Override
//	public List<User> getUserInDescOrder() {
//		return userRepository.findByUserInDescOrder();
//	}

//
//	@Override
//	public List<User> getUserByHotelType() {
//		return userRepository.findUserByHotelGroup();
//	}


	

	@Override
	public List<User> getUserByHotelType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> getUserInDescOrder() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<User> findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}


	/*@Override
	public Optional<User> findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}*/


		

}
