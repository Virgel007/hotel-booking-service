package com.example.hotel_booking_service.web.response;

import com.example.hotel_booking_service.dto.RoomDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {
    private HttpStatus statusCode;
    private String message;
    private RoomDto roomDto;
}
