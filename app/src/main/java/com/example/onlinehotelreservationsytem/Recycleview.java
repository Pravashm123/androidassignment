package com.example.onlinehotelreservationsytem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.com.api.onlinehotelreservationsystem.APIConnection;
import com.com.api.onlinehotelreservationsystem.Roomapi;
import com.example.onlinehotelreservationsytem.R;
import com.model.onlinehotelreservationsytem.Room;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import roomadapter.RoomAdapter;


public class Recycleview extends AppCompatActivity {
    private RecyclerView rec;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyceview);
//        rec= findViewById(R.id.rec);
        getRoom();

    }

    private void getRoom() {
        Roomapi room= APIConnection.getRetrofitroom();
        Call <List<Room>> call= room.getAll();
      call.enqueue(new Callback<List<Room>>() {
          @Override
          public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
              RoomAdapter roomAdapter=new RoomAdapter(Recycleview.this, response.body());
              rec.setAdapter(roomAdapter);
              rec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

          }

          @Override
          public void onFailure(Call<List<Room>> call, Throwable t) {

          }
      });

    }
}
