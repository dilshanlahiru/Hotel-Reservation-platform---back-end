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

import com.backend.HotelReservation.entity.Room;
import com.backend.HotelReservation.exeption.Roomexeption;
import com.backend.HotelReservation.repositary.RoomRepositary;

@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	public RoomRepositary roomrepositary;
	
	@GetMapping("/")
	public List <Room>getAllRooms(){
		return roomrepositary.findAll();
	}
	
	@PostMapping("/")
	public Room  createRoom (@RequestBody Room room) {
		return roomrepositary.save(room);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Room> getRoom(@PathVariable long id) {
		Room room = roomrepositary.findById(id).orElseThrow(() -> new Roomexeption("user not found"));
		return ResponseEntity.ok(room);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteRoom(@PathVariable long id){
		
		Room room = roomrepositary.findById(id).orElseThrow(() -> new Roomexeption("user not found"));
		
		roomrepositary.delete(room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Room> updateRoom (@PathVariable long id, @RequestBody Room room){
		
		Room existigroom = roomrepositary.findById(id).orElseThrow(() -> new Roomexeption("user not found"));
		
		existigroom.setCatogory(room.getCatogory());
		existigroom.setSize(room.getSize());
		existigroom.setDescription(room.getDescription());
		
		Room updated = roomrepositary.save(existigroom);
		return ResponseEntity.ok(updated);
	}
	
	
	

}
