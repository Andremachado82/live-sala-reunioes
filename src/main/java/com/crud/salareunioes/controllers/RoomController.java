package com.crud.salareunioes.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.crud.salareunioes.exceptions.ResourceNotFoundException;
import com.crud.salareunioes.models.Room;
import com.crud.salareunioes.services.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping
	public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room) {
		
		return ResponseEntity.ok().body(roomService.createRoom(room));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Room>> getListRoom() {
		
		return ResponseEntity.ok().body(roomService.getListRoom());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Room> getByIdRoom(@PathVariable Long id) throws ResourceNotFoundException {
		
		return ResponseEntity.ok().body(roomService.getById(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable Long id, @Valid @RequestBody Room room) throws ResourceNotFoundException {
		
		return ResponseEntity.ok().body(roomService.updateRoom(id, room));
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) throws ResourceNotFoundException {
		
		roomService.deleteById(id);
	}
}
