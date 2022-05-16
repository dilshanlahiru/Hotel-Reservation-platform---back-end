package com.backend.HotelReservation.controller;
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

import com.backend.HotelReservation.entity.UseLoginModel;
import com.backend.HotelReservation.entity.User;
import com.backend.HotelReservation.exeption.UserExeption;
import com.backend.HotelReservation.repositary.UserRepositary;

@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping("/user")
public class Usercontroller {
	
	@Autowired
	public UserRepositary userRepositary;
	
	@GetMapping("/")
	public List <User>getAllUsers(){
		return userRepositary.findAll();
	}
	
	@PostMapping("/")
	public User  createUser (@RequestBody User user) {
		return userRepositary.save(user);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity <User> getUser(@PathVariable long userId) {
		User user = userRepositary.findById(userId).orElseThrow(() -> new UserExeption("user not found"));
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity <Map<String, Boolean>> deleteUser(@PathVariable long userId){
		
		User user = userRepositary.findById(userId).orElseThrow(() -> new UserExeption("user not found"));
		
		userRepositary.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity <User> updateUser (@PathVariable long userId, @RequestBody User user){
		
		User existigUser = userRepositary.findById(userId).orElseThrow(() -> new UserExeption("user not found"));
		
		existigUser.setUserName(user.getUserName());
		existigUser.setPhoneNo(user.getPhoneNo());
		existigUser.setEmail(user.getEmail());
		existigUser.setPassword(user.getPassword());
		User updated = userRepositary.save(existigUser);
		return ResponseEntity.ok(updated);
	}
	

	@PostMapping("/Login")
	public Long login  (@RequestBody UseLoginModel useLoginModel) {

		User user = userRepositary.findById(userRepositary.GetUserByid
				(useLoginModel.getEmail())).orElseThrow(() -> new UserExeption("user not found"));
		if( user.getPassword().equals(useLoginModel.getPassword())  ) {
			return user.getUserId() ;
		}
		else {
			return (long) -1;
		}
	}

}
