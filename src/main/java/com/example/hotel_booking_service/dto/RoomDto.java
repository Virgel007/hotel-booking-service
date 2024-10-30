package com.example.hotel_booking_service.dto;

import com.example.hotel_booking_service.model.HotelEntity;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class RoomDto {
    private Integer roomNumber;
    private Integer price;
    private Integer placesInRoom;
    private List<Instant> datesRoomNotAvailable;
    private HotelEntity hotelEntity;
}
