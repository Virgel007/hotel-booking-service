package com.example.hotel_booking_service.mapping;

import com.example.hotel_booking_service.dto.HotelDto;
import com.example.hotel_booking_service.model.HotelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelDto hotelEntityToHotelDto(HotelEntity hotelEntity);

    HotelEntity hotelDtoToHotelEntity(HotelDto hotelDto);
}
