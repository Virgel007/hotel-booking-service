package com.example.hotel_booking_service.mapping;

import com.example.hotel_booking_service.dto.RoomDto;
import com.example.hotel_booking_service.model.RoomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto roomEntityToRoomDto(RoomEntity roomEntity);

    RoomEntity roomDtoToRoomEntity(RoomDto roomDto);
}
