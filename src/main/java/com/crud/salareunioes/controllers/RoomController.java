package com.crud.salareunioes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.salareunioes.models.Room;
import com.crud.salareunioes.services.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping
	public ResponseEntity<Room> createRoom(@RequestBody Room room) {
		
		return ResponseEntity.ok().body(roomService.createRoom(room));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Room>> getListRoom() {
		
		return ResponseEntity.ok().body(roomService.getListRoom());
	}
}
