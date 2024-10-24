package com.example.hotel_booking_service.service.impl;

import com.example.hotel_booking_service.dto.HotelResponse;
import com.example.hotel_booking_service.exception.EntityNotFoundException;
import com.example.hotel_booking_service.mapping.HotelListMapper;
import com.example.hotel_booking_service.mapping.HotelMapper;
import com.example.hotel_booking_service.model.HotelEntity;
import com.example.hotel_booking_service.repostitory.HotelRepository;
import com.example.hotel_booking_service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

    private final HotelListMapper hotelListMapper;

    /**
     * Задание 3. Обработка ошибок
     * ● Опишите DTO, который вернётся в случае ошибок в сервисе.
     * ● Опишите advice, который обработает ошибки и вернёт их пользователям DTO с
     * сообщением, а также корректный HTTP-код ответа с указанием:
     * ○ на отсутствие сущности в БД — возвращение кода 404;
     * ○ клиентские ошибки (неправильный ввод, некорректные данные) —
     * возвращение кода 400;
     * ○ необработанные ошибки — возвращение кода 500.
     */

    @Override
    public HotelResponse findByHotelId(Long id) {
//        HotelResponse response = new HotelResponse();
//        try {
//            HotelEntity hotelEntity = hotelRepository.findById(id).orElseThrow();
//
//        } catch (EntityNotFoundException e) {
//            response.setStatusCode(HttpStatus.NOT_FOUND);
//        }
//
//        if (hotelEntity != null) {
//            response.setHotelDto(hotelMapper.hotelToHotelDto(hotelEntity));
//            response.setStatusCode(HttpStatus.OK);
//            response.setMessage("Hotel found");
//            return response;
//        }
//
//        response.setStatusCode(HttpStatus.NOT_FOUND);
//        response.setMessage("Hotel not found");
//        response.setHotelDto(null);
//        return response;
        return null;
    }

    @Override
    public HotelResponse createHotel(HotelEntity hotelEntity) {
        HotelResponse response = new HotelResponse();

        if (hotelEntity != null) {
            hotelRepository.save(hotelEntity);
            response.setStatusCode(HttpStatus.CREATED);
            response.setMessage("Hotel created");
            response.setHotelDto(hotelMapper.hotelToHotelDto(hotelEntity));
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

        if (hotelEntity != null) {
            HotelEntity hotelInDataBase = hotelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel not found"));
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
                response.setHotelDto(hotelMapper.hotelToHotelDto(hotelInDataBase));
                return response;
            }

            response.setStatusCode(HttpStatus.NOT_FOUND);
            response.setMessage("Hotel not found");
            response.setHotelDto(null);
            return response;
        }

        response.setStatusCode(HttpStatus.BAD_REQUEST);
        response.setMessage("Hotel not update, bad request");
        response.setHotelDto(null);
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
            response.setHotelDto(hotelMapper.hotelToHotelDto(hotelEntity));
            responseList.add(response);
        }

        return responseList;
    }
}
