package com.hotel.BookingManagement.controller;

import com.hotel.BookingManagement.dto.Response;
import com.hotel.BookingManagement.entity.Booking;
import com.hotel.BookingManagement.service.interfac.BookingServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookingControllerTests {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingServiceInterface bookingService;

    private Response mockResponse;
    private Booking bookingRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockResponse = new Response(); // Assuming a no-argument constructor
        mockResponse.setStatusCode(HttpStatus.OK.value()); // Convert HttpStatus to int
        mockResponse.setMessage("Success");
        
        bookingRequest = new Booking();
        bookingRequest.setNumOfAdults(2);
        bookingRequest.setNumOfChildren(1);
        bookingRequest.setCheckInDate(LocalDate.now());
        bookingRequest.setCheckOutDate(LocalDate.now().plusDays(5));
    }

    @Test
    void testSaveBookings() {
        when(bookingService.saveBooking(anyLong(), anyLong(), any(Booking.class))).thenReturn(mockResponse);

        ResponseEntity<Response> response = bookingController.saveBookings(1L, 1L, bookingRequest);

        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
        verify(bookingService).saveBooking(1L, 1L, bookingRequest);
    }

    @Test
    void testGetAllBookings() {
        when(bookingService.getAllBookings()).thenReturn(mockResponse);

        ResponseEntity<Response> response = bookingController.getAllBookings();

        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
        verify(bookingService).getAllBookings();
    }

    @Test
    void testGetBookingByConfirmationCode() {
        String confirmationCode = "ABC123";
        when(bookingService.findBookingByConfirmationCode(confirmationCode)).thenReturn(mockResponse);

        ResponseEntity<Response> response = bookingController.getBookingByConfirmationCode(confirmationCode);

        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
        verify(bookingService).findBookingByConfirmationCode(confirmationCode);
    }

    @Test
    void testCancelBooking() {
        Long bookingId = 1L;
        when(bookingService.cancelBooking(bookingId)).thenReturn(mockResponse);

        ResponseEntity<Response> response = bookingController.cancelBooking(bookingId);

        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
        verify(bookingService).cancelBooking(bookingId);
    }
}
