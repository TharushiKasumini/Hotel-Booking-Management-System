package com.hotel.BookingManagement.service.interfac;

import com.hotel.BookingManagement.dto.LoginRequest;
import com.hotel.BookingManagement.dto.Response;
import com.hotel.BookingManagement.entity.User;

public interface UserServiceInterface {

    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);
}
