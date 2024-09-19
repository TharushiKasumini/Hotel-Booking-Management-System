package com.hotel.BookingManagement.service.interfac;

import com.hotel.BookingManagement.dto.Response;
import com.hotel.BookingManagement.entity.Booking;

public interface BookingServiceInterface {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}
