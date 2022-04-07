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

import com.edu.SpringBootHotelReservationApp.entity.Hotel;
import com.edu.SpringBootHotelReservationApp.entity.Payment;

import com.edu.SpringBootHotelReservationApp.service.PaymentService;


@RestController
@RequestMapping("api/payment")
public class PaymentController {
	private PaymentService paymentService;
	
	
	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	
	@PostMapping
	public ResponseEntity<Payment>savePayment(@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.savePayment(payment),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<Payment>getPaymentById(@PathVariable("id")long id){
		return new ResponseEntity<Payment>(paymentService.getPaymentById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Payment>updatePayment(@PathVariable("id")long id,@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.updatePayment(payment,id),HttpStatus.OK);
	}
	
	
	@GetMapping("/paymentByRoomCharge/{roomCharge}")
	public List<Payment>getPaymentByRoomCharge(@PathVariable("roomCharge")String roomCharge){
		return paymentService.getPaymentByRoomCharge(roomCharge);
	}

	@GetMapping("/paymentByaPaymentDate/{paymentDate}")
	public List<Payment>getPaymentByPaymentDate(@PathVariable("paymentDate")String paymentDate){
		return paymentService.gePaymentByPaymentDate(paymentDate);
	}
	
	@GetMapping("/paymentByCredicardNo/{creditcardNo}")
	public List<Payment>getPaymentByCreditcardNo(@PathVariable("creditcardNo")String creditcardNo){
		return paymentService.gePaymentByCreditcardNo(creditcardNo);
	}
	
	
	

}