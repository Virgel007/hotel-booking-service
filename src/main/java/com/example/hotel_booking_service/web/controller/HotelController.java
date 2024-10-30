package com.example.hotel_booking_service.web.controller;

import com.example.hotel_booking_service.dto.HotelDto;
import com.example.hotel_booking_service.web.response.HotelResponse;
import com.example.hotel_booking_service.mapping.HotelMapper;
import com.example.hotel_booking_service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    private final HotelMapper hotelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.findByHotelId(id));
    }

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody HotelDto hotelDto) {
        return ResponseEntity.ok(hotelService.createHotel(hotelMapper.hotelDtoToHotelEntity(hotelDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponse> updateHotel(@RequestBody HotelDto hotelDto, @PathVariable Long id) {
        return ResponseEntity.ok(hotelService.updateHotel(hotelMapper.hotelDtoToHotelEntity(hotelDto), id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<HotelResponse>> getAllHotels() {
        return ResponseEntity.ok(hotelService.findAllHotels());
    }
}