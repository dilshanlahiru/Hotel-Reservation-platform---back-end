package com.backend.HotelReservation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.HotelReservation.entity.PaymentDetails;
import com.backend.HotelReservation.repositary.PaymentDetailsRepositary;

@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	public PaymentDetailsRepositary paymentDetailsRepositary;
	
	@PostMapping("/")
	public PaymentDetails  createUser (@RequestBody PaymentDetails paymentDetails) {
		return paymentDetailsRepositary.save(paymentDetails);
	}

}
