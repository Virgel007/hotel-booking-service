package com.example.hotel_booking_service.service;

import com.example.hotel_booking_service.model.RoomEntity;
import com.example.hotel_booking_service.web.response.RoomResponse;

import java.util.List;

public interface RoomService {

    RoomResponse findByRoomId(Long id);

    RoomResponse createRoom(RoomEntity roomEntity);

    RoomResponse updateRoom(RoomEntity roomEntity, Long id);

    void deleteRoom(Long id);

    List<RoomResponse> findAllRooms();
}
