package com.com.api.onlinehotelreservationsystem;

import com.model.onlinehotelreservationsytem.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Userapi {
    @POST("users/signup")
    Call<ResponseBody> signup(@Body User user);
    //  @GET("users/{id}")
//    Call<Users> getUserById(@Path("id") String id);
    @POST("users/login")
    Call<User> login(@Body User user);
}
