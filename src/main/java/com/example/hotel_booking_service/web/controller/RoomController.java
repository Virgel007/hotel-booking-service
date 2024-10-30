package com.example.hotel_booking_service.web.controller;

import com.example.hotel_booking_service.dto.HotelDto;
import com.example.hotel_booking_service.dto.RoomDto;
import com.example.hotel_booking_service.mapping.RoomMapper;
import com.example.hotel_booking_service.service.RoomService;
import com.example.hotel_booking_service.web.response.RoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    private final RoomMapper roomMapper;

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.findByRoomId(id));
    }

    @PostMapping
    public ResponseEntity<RoomResponse> createRoom(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(roomService.createRoom(roomMapper.roomDtoToRoomEntity(roomDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> updateRoom(@RequestBody RoomDto roomDto, @PathVariable Long id) {
        return ResponseEntity.ok(roomService.updateRoom(roomMapper.roomDtoToRoomEntity(roomDto), id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRooms() {
        return ResponseEntity.ok(roomService.findAllRooms());
    }
}
