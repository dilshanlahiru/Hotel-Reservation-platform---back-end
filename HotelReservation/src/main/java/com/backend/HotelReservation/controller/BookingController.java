package com.backend.HotelReservation.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.backend.HotelReservation.entity.Booking;
import com.backend.HotelReservation.exeption.BookingExeption;
import com.backend.HotelReservation.repositary.BookingRepositary;


@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping("/book")
public class BookingController {
	
	@Autowired
	public BookingRepositary bookingrepositary;
	
	@GetMapping("/")
	public List <Booking>getAllBookings(){
		return bookingrepositary.findAll();
	}
	
	@PostMapping("/")
	public Booking  createBooking (@RequestBody Booking booking) {
		return bookingrepositary.save(booking);
	}
	
	@GetMapping("/{bookingId}")
	public ResponseEntity <Booking> getbooking(@PathVariable long bookingId) {
		Booking booking = bookingrepositary.findById(bookingId).orElseThrow(() -> new BookingExeption("booking not found"));
		return ResponseEntity.ok(booking);
	}
	
	
	@DeleteMapping("/{bookingId}")
	public ResponseEntity <Map<String, Boolean>> deletebooking(@PathVariable long bookingId){
		
		Booking booking = bookingrepositary.findById(bookingId).orElseThrow(() -> new BookingExeption("booking not found"));
		
		bookingrepositary.delete(booking);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	@PutMapping("/{bookingId}")
	public ResponseEntity <Booking> updateBooking (@PathVariable long bookingId, @RequestBody Booking booking){
		
		Booking existingBooking = bookingrepositary.findById(bookingId).orElseThrow(() -> new BookingExeption("booking not found"));
		
//		existingBooking.setCustomerId(booking.getCustomerId());
		existingBooking.setCategory(booking.getCategory());
		existingBooking.setSize(booking.getSize());
		existingBooking.setArrivalDate(booking.getArrivalDate());
		existingBooking.setDepartureDate(booking.getDepartureDate());
		
		Booking updated = bookingrepositary.save(existingBooking);
		return ResponseEntity.ok(updated);
	}
	
	@GetMapping("/checkAvailability/{arrivalDate}/{departureDate}/{category}/{size}")
//	public int checkAvailability(@PathVariable Date arrivalDate,@PathVariable Date departureDate,@PathVariable  String category,@PathVariable  String size){
	public int checkAvailability(@PathVariable String arrivalDate,@PathVariable String departureDate,@PathVariable  String category,@PathVariable  String size){
		int availableRoomCount = bookingrepositary.availableRoomCountByCategary(category, size);
		
		
//		Date aDate = null, dDate = null;
//		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
//        try {
//			aDate = dt.parse(arrivalDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        try {
//			dDate = dt.parse(departureDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(aDate);
//        System.out.println(dDate);
//        System.out.println(size);
//        System.out.println(category + arrivalDate);
        int bookedCount =bookingrepositary.availableCount4(arrivalDate, departureDate, category, size);
//        System.out.println(bookedCount);
//        System.out.println(availableRoomCount);
        return (availableRoomCount - bookedCount);
//		return (bookingrepositary.availableCount(aDate, dDate, category, size));
//		return (bookingrepositary.availableCount1(category, size));
//      return (bookingrepositary.availableCount2(category, size));
        }
	
	@GetMapping("/booking/{cusId}")
	public List <Booking> getAllbookingById(@PathVariable long cusId) {
		return(bookingrepositary.getAllUsersBooking(cusId));
	}
	

}
