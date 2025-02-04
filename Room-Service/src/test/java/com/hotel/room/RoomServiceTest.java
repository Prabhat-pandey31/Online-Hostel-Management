package com.hotel.room;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hotel.room.entity.Room;
import com.hotel.room.repository.RoomRepository;
import com.hotel.room.service.RoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    public RoomServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRoomsTest() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room());

        when(roomRepository.findAll()).thenReturn(rooms);

        List<Room> result = roomService.getAllRooms();

        assertEquals(1, result.size());
        verify(roomRepository, times(1)).findAll();
    }

    @Test
    void addRoomTest() {
        Room room = new Room();
        room.setType("Single");
        room.setPrice(100.0);
        room.setAvailability(true);

        when(roomRepository.save(room)).thenReturn(room);

        Room savedRoom = roomService.addRoom(room);

        assertEquals("Single", savedRoom.getType());
        verify(roomRepository, times(1)).save(room);
    }
}

