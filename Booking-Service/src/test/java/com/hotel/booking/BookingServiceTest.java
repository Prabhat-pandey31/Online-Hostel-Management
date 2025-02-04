package com.hotel.booking;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hotel.booking.entities.Booking;
import com.hotel.booking.repository.BookingRepository;
import com.hotel.booking.services.BookingService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    public BookingServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBookingsTest() {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking());

        when(bookingRepository.findAll()).thenReturn(bookings);

        List<Booking> result = bookingService.getAllBookings();

        assertEquals(1, result.size());
        verify(bookingRepository, times(1)).findAll();
    }

    @Test
    void createBookingTest() {
        Booking booking = new Booking();
        booking.setRoomId(1L);

        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking savedBooking = bookingService.createBooking(booking);

        assertEquals(1L, savedBooking.getRoomId());
        verify(bookingRepository, times(1)).save(booking);
    }
}

