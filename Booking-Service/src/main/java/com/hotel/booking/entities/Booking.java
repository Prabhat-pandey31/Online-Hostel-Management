package com.hotel.booking.entities;



import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long roomId;

    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    private String status; // e.g., "CONFIRMED", "CANCELLED"
}

