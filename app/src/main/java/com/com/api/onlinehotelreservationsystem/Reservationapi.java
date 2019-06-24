package com.com.api.onlinehotelreservationsystem;

import com.model.onlinehotelreservationsytem.Reservation;
import com.model.onlinehotelreservationsytem.Room;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Reservationapi {
    @POST("roomreservation")
    Call<ResponseBody> reserve(@Body Reservation reservation);
}
