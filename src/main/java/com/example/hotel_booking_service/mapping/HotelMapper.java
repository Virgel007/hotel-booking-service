package com.example.hotel_booking_service.mapping;

import com.example.hotel_booking_service.dto.HotelDto;
import com.example.hotel_booking_service.model.HotelEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelDto hotelToHotelDto(HotelEntity hotelEntity);

    HotelEntity hotelDtoToHotel(HotelDto hotelDto);
}
