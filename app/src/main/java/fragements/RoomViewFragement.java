package fragements;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.com.api.onlinehotelreservationsystem.APIConnection;
import com.com.api.onlinehotelreservationsystem.Roomapi;
import com.example.onlinehotelreservationsytem.R;
import com.example.onlinehotelreservationsytem.Recycleview;
import com.model.onlinehotelreservationsytem.Room;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import roomadapter.RoomAdapter;

public class RoomViewFragement extends Fragment {
    private RecyclerView rec;
//    private ArrayList<Room> listroom = new ArrayList<Room>();
private List<Room> listroom=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recyceview, container, false);
        rec = view.findViewById(R.id.rec);
        //   rec.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        rec.setLayoutManager(manager);
        getRoom();
        RoomAdapter roomAdapter=new RoomAdapter(getContext(),listroom);
        rec.setAdapter(roomAdapter);

        return view;

    }
    private void getRoom()
    {
        Roomapi room= APIConnection.getRetrofitroom();
        Call<List<Room>> reslist  = room.getAll();

      reslist.enqueue(new Callback<List<Room>>() {
          @Override
          public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
              listroom = (List<Room>) response.body();


              for (Room i: listroom)
              {
                  Log.d("Room", i.getDesc()+" "+i.getRoomtype()+" "+i.getBedtype()+" "+i.getImage()+" "+i.get_id());
              }

             RoomAdapter roomAdapter=new RoomAdapter(getContext(), listroom);
              rec.setAdapter(roomAdapter);

          }

          @Override
          public void onFailure(Call<List<Room>> call, Throwable t) {

          }
      });

    }
}
