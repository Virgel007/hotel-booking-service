package com.example.hotel_booking_service.mapping;

import com.example.hotel_booking_service.dto.HotelDto;
import com.example.hotel_booking_service.model.HotelEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HotelMapper.class})
public interface HotelListMapper {

    List<HotelEntity> toHotelList(List<HotelDto> hotelDtoList);

    List<HotelDto> toHotelDtoList(List<HotelEntity> hotelEntities);
}
