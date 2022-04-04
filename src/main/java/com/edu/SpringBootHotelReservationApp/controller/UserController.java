package com.edu.SpringBootHotelReservationApp.controller;

import java.util.List;

//import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootHotelReservationApp.entity.User;
import com.edu.SpringBootHotelReservationApp.service.UserService;

@RestController
//@Controller
@RequestMapping("/api/user")// url

public class UserController {
	private UserService userService;

	/*public UserController( UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	// saveUser(User obj)
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	String index(){
		return "index";
	}
	
	@GetMapping("/getUser")
	public String getAllUser(Model model){
		List<User> user = userService.getAllUser();
		model.addAttribute("user", user);
		System.out.println("user list");
		return "list-user";
		
	}
	
	@GetMapping("/registration")
	public String registration(User user){
		return "add-user";
	}
	
	
	
	
	
	
	@GetMapping
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("{id}")//4
	public ResponseEntity<User>getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@GetMapping("/userByFirstName/{firstName}")//john
	public List<User> getUserByFirstName(@PathVariable("firstName")String firstName){
		return UserService.getUserByFirstName(firstName);//john
	}
	
	@GetMapping("/userByLastName/{lastName}")//doe
	public List<User> getUserByLastName(@PathVariable("lastName") String lastName){
		return UserService.getUserByLastName(lastName);//deo
		
	}
	
		@GetMapping("/userByFirstNameAndLastName")
	public List<User> getUserByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return userService.getUserByFirstNameAndLastName(firstName, lastName);
		
	}
	

	@GetMapping("/userByFirstNameOrLastName")
	public List<User> getUserByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
	{
		return userService.getUserByFirstNameOrLastName(firstName, lastName);
		
	}
	
	@GetMapping("/userByIds")
	public List<User> getUsersByIds(@RequestParam(value="id") List<Long> id){
		return  userService.getUsersById(id);
	}
	
	/*@GetMapping("/userByHotel/{id}")
	public List<User> getuserByHotel(@PathVariable("id") Long id){
		return userService. getuserByHotel(id);
		
	}*/
	
	@GetMapping("/userByHotelType")
	public List<User> getUserByHotelType(){
		return userService.getUserByHotelType();
	}
	
	
		@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
		
	}
		
	@GetMapping("/userInDescOrder")
	public List<User> getUserInDescOrder(){
		return userService.getUserInDescOrder();
	}

	// CRUD
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User record deleted ",HttpStatus.OK);
		
	}
	
	
	
	
}


	/*@GetMapping("/")
	String index(){
		return "index";
	}
	
	@GetMapping("/getUser")
	public String getAllUser(Model model){
		List<User> user = userService.getAllUser();
		model.addAttribute("user", user);
		System.out.println("user list");
		return "list-user";
		
	}
	
	@GetMapping("/registration")
	public String registration(User user){
		return "add-user";
	}
	
	public ResponseEntity<User>getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
		
	}
	
}*/

	