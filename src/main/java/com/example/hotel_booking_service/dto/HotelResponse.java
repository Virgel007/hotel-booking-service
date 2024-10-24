package com.example.hotel_booking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {
    private HttpStatus statusCode;
    private String message;
    private HotelDto hotelDto;
}
