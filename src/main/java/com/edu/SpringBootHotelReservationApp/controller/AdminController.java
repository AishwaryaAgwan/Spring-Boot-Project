package com.edu.SpringBootHotelReservationApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootHotelReservationApp.entity.Admin;
import com.edu.SpringBootHotelReservationApp.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@PostMapping
	public ResponseEntity<Admin> saveuser(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Admin> getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
	@GetMapping("{id}")
	public ResponseEntity<Admin>getAdminById(@PathVariable("id") long id) {
		return new ResponseEntity<Admin>(adminService.getAdminById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id, @RequestBody Admin admin){
		
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, id),HttpStatus.OK);
		
	}
	
}
