package com.example.hotel_booking_service.exception;

public class UpdateStateException extends RuntimeException {
    public UpdateStateException(String message) {
        super(message);
    }
}
