package com.com.api.onlinehotelreservationsystem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConnection {
    Bitmap bitmap;

    public static Userapi getRetrofit() {
        String BASE_URL = "http://10.0.2.2:3000/";
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.build()).build();
        Userapi user = retrofit.create(Userapi.class);
        return user;

    }
    public static Roomapi getRetrofitroom() {
        String BASE_URL = "http://10.0.2.2:3000/";
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.build()).build();
        Roomapi room = retrofit.create(Roomapi.class);
        return room;

    }
    public static Reservationapi getReservation() {
        String BASE_URL = "http://10.0.2.2:3000/";
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.build()).build();
        Reservationapi reservationapi = retrofit.create(Reservationapi.class);
        return reservationapi;

    }
    public static MultipartBody.Part getImageByte(Bitmap bm, String filename)
    {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        bm.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray = stream.toByteArray();

        MultipartBody.Part body= MultipartBody.Part.createFormData("imageFile",filename,
                RequestBody.create(MediaType.parse("multipart/form-data"),byteArray));

        return body;
    }
//    public static void strictMode()
//    {
//        android.os.StrictMode.ThreadPolicy policy =
//                new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
//        android.os.StrictMode.setThreadPolicy(policy);
//    }
//    public static Bitmap loadFromUrl(String imgName)
//    {
//        strictMode();
//        try
//        {
//            String imgUrl = "http://10.0.2.2:3000/images/"+imgName;
//            URL url  = new URL(imgUrl);
//            return BitmapFactory.decodeStream((InputStream)url.getContent());
//        }
//
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

}
