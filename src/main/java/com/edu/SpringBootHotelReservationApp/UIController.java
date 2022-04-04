package com.edu.SpringBootHotelReservationApp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.SpringBootHotelReservationApp.entity.Hotel;
import com.edu.SpringBootHotelReservationApp.entity.User;
import com.edu.SpringBootHotelReservationApp.service.HotelService;
import com.edu.SpringBootHotelReservationApp.service.UserService;
import com.edu.SpringBootHotelReservationApp.service.AdminService;

@Controller
public class UIController {
	
	private UserService userService;
	private HotelService hotelService;
	private AdminService adminService;
	
	
@Autowired	
public UIController(UserService userService, HotelService hotelService,
			AdminService adminService) {
		super();
		this.userService = userService;
		this.hotelService = hotelService;
		this.adminService = adminService;
	}

@GetMapping("/")
	
	String index() {
		return "index";/// index.html
	}

// User
@GetMapping("/registration")
public String userRegistrationForm(Model model) {
	User user = new User();
	model.addAttribute("user", user);
    return "add-user";
}

@PostMapping("/saveUser")
public String saveUser(@Valid User user, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    userService.saveUser(user);
	List<User> users =  userService.getAllUser();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getUsers";
   }
@GetMapping("/getUsers")
public String getAllUser(Model model) {
	
	List<User> users =  userService.getAllUser();
	
	model.addAttribute("users", users);
	
    return "list-user";}

@GetMapping("/updateUsers/{id}")
public String updateUsers(@PathVariable(value="id") long id, Model model)
{
	User user=userService.getUserById(id);
	model.addAttribute("user",user);
	return "update-user";
}

@GetMapping("/deleteUsers/{id}")
public String deleteUsers(@PathVariable  long id, Model model)
{
	userService.deleteUser(id);
	model.addAttribute("message", "Product record deleted successfully");
	getAllUser(model);
	return "list-user";
}


// Hotel
@GetMapping("/hotelRegister")
public String hotelRegistrationForm(Model model) {
	Hotel hotel = new Hotel();
	model.addAttribute("hotel", hotel);
    return "add-hotel";
}
@PostMapping("/saveHotel")
public String saveHotel(@Valid Hotel hotel, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    hotelService.saveHotel(hotel);
	List<Hotel> hotels =  hotelService.getAllHotel();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getHotels";
    }

@GetMapping("/getHotels")
public String getAllHotel(Model model) {
	
	List<Hotel> hotels =  hotelService.getAllHotel();
	
	model.addAttribute("hotel", hotels);
	
    return "list-hotel";
    }


@GetMapping("/getGallery")
public String getAllGallery(Model model) {	
    return "gallery";
    }

@GetMapping("/getAbout")
public String getAllAbout(Model model) {	
    return "about";
    }
@GetMapping("/getContact")
public String getAllContact(Model model) {	
    return "contact";
    }

@GetMapping("/getServices")
public String getAllServices(Model model) {	
    return "services";
    }
}


