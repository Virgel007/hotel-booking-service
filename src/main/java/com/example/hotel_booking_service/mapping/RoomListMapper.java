package com.example.hotel_booking_service.mapping;

import com.example.hotel_booking_service.dto.RoomDto;
import com.example.hotel_booking_service.model.RoomEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoomMapper.class})
public interface RoomListMapper {
    List<RoomEntity> toRoomEntityList(List<RoomDto> roomDtoList);

    List<RoomDto> toRoomEntityDtoList(List<RoomEntity> roomEntities);
}
