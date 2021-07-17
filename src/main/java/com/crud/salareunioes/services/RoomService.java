package com.crud.salareunioes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.salareunioes.models.Room;
import com.crud.salareunioes.repositories.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public Room createRoom(Room room) {
		
		return roomRepository.save(room);
	} 
	
	public List<Room> getListRoom() {
		List<Room> listRoom = roomRepository.findAll();
		
		return listRoom;
	} 

}
