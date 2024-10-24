package com.example.hotel_booking_service.service;

import com.example.hotel_booking_service.dto.HotelResponse;
import com.example.hotel_booking_service.model.HotelEntity;

import java.util.List;

public interface HotelService {

    HotelResponse findByHotelId(Long id);

    HotelResponse createHotel(HotelEntity hotelEntity);

    HotelResponse updateHotel(HotelEntity hotelEntity, Long id);

    void deleteHotel(Long id);

    List<HotelResponse> findAllHotels();
}
