package roomadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlinehotelreservationsytem.R;
import com.model.onlinehotelreservationsytem.Room;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.Holder>
{
    private Context context;
    private List<Room> listroom;
    public static final String BASE_URL = "http://10.0.2.2:3000/";
    Bitmap bitmap;

    public RoomAdapter(Context context, List<Room> listroom) {
        this.context = context;
        this.listroom = listroom;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.fetchdata,viewGroup,false);
        return new Holder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

   final Room room =listroom.get(i);
   holder.txtbed.setText(room.getBedtype());
   holder.txtprice.setText(room.getPrice());
  // holder.txtdesc.setText(room.getDesc());
   holder.txtroom.setText(room.getRoomtype());
        stricmode();
       // String imagepath="localhost:3000/uploads/images/" + room.getImage();
      //  String imagepath="http://10.0.2.2:3000/public/uploads/" + room.getImage();
        String imagepath=listroom.get(i).getImage();
        final String path = BASE_URL+"/uploads"+"/"+imagepath;


        try {

            URL url =new URL(path);
           //holder.img.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
            holder.img.setImageBitmap(bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void stricmode() {
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public int getItemCount() {
        return listroom.size();
    }

    public class  Holder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtprice,txtdesc,txtroom,txtbed;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txtprice=itemView.findViewById(R.id.txtprice);
            txtbed=itemView.findViewById(R.id.txtbed);
            txtroom=itemView.findViewById(R.id.txtroom);
          //  txtdesc=itemView.findViewById(R.id.txt)
            img=itemView.findViewById(R.id.fimg);

        }
    }
}
