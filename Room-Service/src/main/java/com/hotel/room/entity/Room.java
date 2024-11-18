package com.hotel.room.entity;



import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type; // e.g., Single, Double, Suite

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean availability;
}

