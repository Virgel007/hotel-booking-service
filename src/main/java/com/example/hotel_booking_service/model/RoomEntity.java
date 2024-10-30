package com.example.hotel_booking_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_number")
    private Integer roomNumber;
    @Column(name = "price")
    private Integer price;
    @Column(name = "places_in_room")
    private Integer placesInRoom;
    @Column(name = "dates_room_not_available")
    private List<Instant> datesRoomNotAvailable;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;
}
