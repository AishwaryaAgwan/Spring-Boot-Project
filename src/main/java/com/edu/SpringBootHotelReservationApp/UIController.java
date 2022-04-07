package com.edu.SpringBootHotelReservationApp;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.SpringBootHotelReservationApp.entity.Booking;
import com.edu.SpringBootHotelReservationApp.entity.Hotel;
import com.edu.SpringBootHotelReservationApp.entity.User;
import com.edu.SpringBootHotelReservationApp.entity.Booking;
import com.edu.SpringBootHotelReservationApp.entity.Payment;
import com.edu.SpringBootHotelReservationApp.service.HotelService;
import com.edu.SpringBootHotelReservationApp.service.UserService;
import com.edu.SpringBootHotelReservationApp.service.BookingService;
import com.edu.SpringBootHotelReservationApp.service.PaymentService;

@Controller
public class UIController {
	
	private UserService userService;
	private HotelService hotelService;
	private PaymentService paymentService;
	private BookingService bookingService;
	
	
	
@Autowired	
public UIController(UserService userService, HotelService hotelService,PaymentService paymentService,BookingService bookingService) {
		super();
		this.userService = userService;
		this.hotelService = hotelService;
		this.paymentService = paymentService;
		this.bookingService = bookingService;
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
	model.addAttribute("message", "User record deleted successfully");
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
	
	model.addAttribute("hotels", hotels);
	
    return "list-hotel";}

@GetMapping("/updateHotels/{id}")
public String updateHotels(@PathVariable(value="id") long id, Model model)
{
	Hotel hotel=hotelService.getHotelById(id);
	model.addAttribute("hotel",hotel);
	return "update-hotel";
}

@GetMapping("/deleteHotels/{id}")
public String deleteHotels(@PathVariable  long id, Model model)
{
	hotelService.deleteHotel(id);
	model.addAttribute("message", "hotel record deleted successfully");
	getAllHotel(model);
	return "list-hotel";
}


//Booking
@GetMapping("/bookingRegister")
public String bookingRegistrationForm(Model model) {
	Booking booking = new Booking();
	model.addAttribute("booking", booking);
    return "add-booking";
}

@PostMapping("/savebooking")
public String addbooking(@Validated  Booking booking, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "add-booking";
	else {
	bookingService.saveBooking(booking);
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getbookings";
}
    @GetMapping("/getbookings")
    public String getAllBooking(Model model) {
    	
		List<Booking> bookings =  bookingService.getAllBooking();
    	
    	model.addAttribute("bookings", bookings);
    	
        return "list-booking";
        }
    
  //payment
    @GetMapping("/paymentRegister")
    public String paymentRegistrationForm(Model model) {
    	Payment payment = new Payment();
    	model.addAttribute("payment", payment);
        return "add-payment";
    }

    @PostMapping("/savePayment")
    public String savePayment(@Validated  Payment payment, Errors errors, Model model) {
    	if(null != errors && errors.getErrorCount() > 0)
    		return "add-payment";
    	else {
        paymentService.savePayment(payment);
    	List<Payment> payments =  paymentService.getAllPayment();
        model.addAttribute("successMessage", "Details are saved successfully");
    	}
        return "redirect:/getPayments";
        
    }

    @GetMapping("/getPayments")
    public String getAllPayment(Model model) {
    	
    	List<Payment> payments =  paymentService.getAllPayment();
    	
    	model.addAttribute("payments", payments);
    	
        return "list-payment";
        }   
//Gallery
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


