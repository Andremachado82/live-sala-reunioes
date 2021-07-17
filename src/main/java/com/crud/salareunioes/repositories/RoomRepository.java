package com.crud.salareunioes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.salareunioes.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
