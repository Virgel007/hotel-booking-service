package com.example.hotel_booking_service.dto;

import lombok.Data;

@Data
public class HotelDto {
    private String name;
    private String title;
    private String city;
    private String address;
    private Integer distance;
    private Double rating;
}
