package com.example.hotel_booking_service.service.impl;

import com.example.hotel_booking_service.mapping.HotelListMapper;
import com.example.hotel_booking_service.mapping.HotelMapper;
import com.example.hotel_booking_service.model.HotelEntity;
import com.example.hotel_booking_service.repostitory.HotelRepository;
import com.example.hotel_booking_service.service.HotelService;
import com.example.hotel_booking_service.web.response.HotelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

    private final HotelListMapper hotelListMapper;


    @Override
    public HotelResponse findByHotelId(Long id) {
        HotelResponse response = new HotelResponse();
        HotelEntity hotelEntity = hotelRepository.findById(id).orElseGet(
                () -> {
                    response.setStatusCode(HttpStatus.NOT_FOUND);
                    response.setMessage("Hotel not found");
                    response.setHotelDto(null);
                    return null;
                }
        );

        if (hotelEntity != null) {
            response.setHotelDto(hotelMapper.hotelEntityToHotelDto(hotelEntity));
            response.setStatusCode(HttpStatus.OK);
            response.setMessage("Hotel found");
            return response;
        }

        return response;
    }

    @Override
    public HotelResponse createHotel(HotelEntity hotelEntity) {
        HotelResponse response = new HotelResponse();

        if (hotelEntity != null) {
            hotelRepository.save(hotelEntity);
            response.setStatusCode(HttpStatus.CREATED);
            response.setMessage("Hotel created");
            response.setHotelDto(hotelMapper.hotelEntityToHotelDto(hotelEntity));
            return response;
        }

        response.setStatusCode(HttpStatus.BAD_REQUEST);
        response.setMessage("Hotel not created, bad request");
        response.setHotelDto(null);
        return response;
    }

    @Override
    public HotelResponse updateHotel(HotelEntity hotelEntity, Long id) {
        HotelResponse response = new HotelResponse();

        HotelEntity hotelInDataBase = hotelRepository.findById(id).orElseGet(
                () -> {
                    response.setStatusCode(HttpStatus.NOT_FOUND);
                    response.setMessage("Hotel not found");
                    response.setHotelDto(null);
                    return null;
                }
        );

        if (hotelInDataBase != null) {
            hotelInDataBase.setName(hotelEntity.getName());
            hotelInDataBase.setTitle(hotelEntity.getTitle());
            hotelInDataBase.setCity(hotelEntity.getCity());
            hotelInDataBase.setAddress(hotelEntity.getAddress());
            hotelInDataBase.setDistance(hotelEntity.getDistance());
            hotelInDataBase.setRating(hotelEntity.getRating());
            hotelRepository.save(hotelInDataBase);
            response.setStatusCode(HttpStatus.OK);
            response.setMessage("Hotel updated");
            response.setHotelDto(hotelMapper.hotelEntityToHotelDto(hotelInDataBase));
            return response;
        }

        return response;
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<HotelResponse> findAllHotels() {
        List<HotelResponse> responseList = new ArrayList<>();
        List<HotelEntity> hotelEntities = hotelRepository.findAll();

        for (HotelEntity hotelEntity : hotelEntities) {
            HotelResponse response = new HotelResponse();
            response.setStatusCode(HttpStatus.OK);
            response.setMessage("Hotel found");
            response.setHotelDto(hotelMapper.hotelEntityToHotelDto(hotelEntity));
            responseList.add(response);
        }

        return responseList;
    }
}
