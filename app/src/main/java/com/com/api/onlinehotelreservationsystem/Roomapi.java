package com.com.api.onlinehotelreservationsystem;

import com.model.onlinehotelreservationsytem.ImageResponse;
import com.model.onlinehotelreservationsytem.Room;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Roomapi {
    @POST("room")
    Call<ResponseBody> Room(@Body Room room);

    @Multipart
    @POST("upload")
    Call<ImageResponse> upload(@Part() MultipartBody.Part file);

    @GET("room")
    Call<List<Room>> getAll();


    @GET("room/{id}")
    Call<Room> getByID(@Path("id") String id);


}
