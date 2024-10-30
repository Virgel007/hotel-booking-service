package com.example.hotel_booking_service.service.impl;

import com.example.hotel_booking_service.mapping.RoomListMapper;
import com.example.hotel_booking_service.mapping.RoomMapper;
import com.example.hotel_booking_service.model.HotelEntity;
import com.example.hotel_booking_service.model.RoomEntity;
import com.example.hotel_booking_service.repostitory.RoomRepository;
import com.example.hotel_booking_service.service.RoomService;
import com.example.hotel_booking_service.web.response.HotelResponse;
import com.example.hotel_booking_service.web.response.RoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    private final RoomListMapper roomListMapper;

    @Override
    public RoomResponse findByRoomId(Long id) {
        RoomResponse response = new RoomResponse();

        RoomEntity roomEntity = roomRepository.findById(id).orElseGet(
                () -> {
                    response.setStatusCode(HttpStatus.NOT_FOUND);
                    response.setMessage("Room not found");
                    response.setRoomDto(null);
                    return null;
                }
        );

        if (roomEntity != null) {
            response.setRoomDto(roomMapper.roomEntityToRoomDto(roomEntity));
            response.setStatusCode(HttpStatus.OK);
            response.setMessage("Room found");
            return response;
        }

        return response;
    }

    @Override
    public RoomResponse createRoom(RoomEntity roomEntity) {
        RoomResponse response = new RoomResponse();

        if (roomEntity != null) {
            roomRepository.save(roomEntity);
            response.setStatusCode(HttpStatus.CREATED);
            response.setMessage("Room created");
            response.setRoomDto(roomMapper.roomEntityToRoomDto(roomEntity));
            return response;
        }

        response.setStatusCode(HttpStatus.BAD_REQUEST);
        response.setMessage("Room not created, bad request");
        response.setRoomDto(null);
        return response;
    }

    @Override
    public RoomResponse updateRoom(RoomEntity roomEntity, Long id) {
        RoomResponse response = new RoomResponse();

        RoomEntity roomInDataBase = roomRepository.findById(id).orElseGet(
                () -> {
                    response.setStatusCode(HttpStatus.NOT_FOUND);
                    response.setMessage("Room not found");
                    response.setRoomDto(null);
                    return null;
                }
        );

        if (roomInDataBase != null) {
            roomInDataBase.setRoomNumber(roomEntity.getRoomNumber());
            roomInDataBase.setPrice(roomEntity.getPrice());
            roomInDataBase.setPlacesInRoom(roomEntity.getPlacesInRoom());
            roomInDataBase.setDatesRoomNotAvailable(roomEntity.getDatesRoomNotAvailable());
            roomInDataBase.setHotelEntity(roomEntity.getHotelEntity());
            roomRepository.save(roomInDataBase);
            response.setStatusCode(HttpStatus.OK);
            response.setMessage("Hotel updated");
            response.setRoomDto(roomMapper.roomEntityToRoomDto(roomInDataBase));
            return response;
        }

        return response;
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<RoomResponse> findAllRooms() {
        List<RoomResponse> responseList = new ArrayList<>();
        List<RoomEntity> roomEntities = roomRepository.findAll();

        for (RoomEntity roomEntity : roomEntities) {
            RoomResponse response = new RoomResponse();
            response.setStatusCode(HttpStatus.OK);
            response.setMessage("Room found");
            response.setRoomDto(roomMapper.roomEntityToRoomDto(roomEntity));
            responseList.add(response);
        }

        return responseList;
    }
}
