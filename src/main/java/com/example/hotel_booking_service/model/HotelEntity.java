package com.example.hotel_booking_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "hotels")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "distance")
    private Integer distance;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(mappedBy = "hotelEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoomEntity> rooms;
}
