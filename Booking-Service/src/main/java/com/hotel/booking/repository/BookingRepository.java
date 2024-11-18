package com.hotel.booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.booking.entities.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
}

