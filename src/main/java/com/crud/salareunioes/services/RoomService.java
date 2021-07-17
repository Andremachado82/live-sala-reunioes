package com.crud.salareunioes.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.salareunioes.exceptions.ResourceNotFoundException;
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

	public Room getById(Long id) throws ResourceNotFoundException {

		return buscarRoomPorId(id);
	}

	public Room updateRoom(Long id, Room room) throws ResourceNotFoundException {
		
		Room roomExistente = buscarRoomPorId(id);;
		
		BeanUtils.copyProperties(room, roomExistente, "id");
		
		return roomRepository.save(room);
	}
	
	public Room buscarRoomPorId(Long id) throws ResourceNotFoundException {
		Room  roomExistente = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Room.class.getName()));
		return roomExistente;
	}
	
	public void deleteById(Long id) throws ResourceNotFoundException {

		buscarRoomPorId(id);
		
		roomRepository.deleteById(id);
	}

}
