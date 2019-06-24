package com.example.onlinehotelreservationsytem;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.com.api.onlinehotelreservationsystem.APIConnection;
import com.com.api.onlinehotelreservationsystem.Roomapi;
import com.model.onlinehotelreservationsytem.ImageResponse;
import com.model.onlinehotelreservationsytem.Room;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Roomactivity extends AppCompatActivity {
private ImageView img;
private EditText desc,price,bedtype,roomtype;
private Button upload,save;
    private Uri filePath;
    private String filename;
    private Bitmap bm;
    private String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        img=findViewById(R.id.imgView);
        desc=findViewById(R.id.desc);
        price=findViewById(R.id.aPrice);
        bedtype=findViewById(R.id.bedtype);
        roomtype=findViewById(R.id.roomtype);
        upload=findViewById(R.id.uploadBtn);
        save=findViewById(R.id.aBtn);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "select picture"), 2);
            }

        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Roomapi room= APIConnection.getRetrofitroom();
                Call<ImageResponse> call = room.upload(APIConnection.getImageByte(bm, filename));
              call.enqueue(new Callback<ImageResponse>() {
                  @Override
                  public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
  if(response.isSuccessful()){
      imageName = response.body().getFilename();
      Log.d("msg","Succfully uploaded "+imageName);
      Roomapi room= APIConnection.getRetrofitroom();
      Call <ResponseBody> call2= room.Room(new Room(desc.getText().toString(),
              price.getText().toString(),bedtype.getText().toString(),imageName,roomtype.getText().toString()));
      call2.enqueue(new Callback<ResponseBody>() {
          @Override
          public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
              if(response.isSuccessful()){
                  Toast.makeText(Roomactivity.this, "Success", Toast.LENGTH_LONG).show();
                  desc.setText("");
                  price.setText("");
                  bedtype.setText("");
                  roomtype.setText("");
                  img.setImageBitmap(null);

              }
              else {
                  Toast.makeText(Roomactivity.this, "failed", Toast.LENGTH_LONG).show();

              }
          }

          @Override
          public void onFailure(Call<ResponseBody> call, Throwable t) {
              Log.d("err", t.getLocalizedMessage());

          }
      });

  }
  else {
      Log.d("msg","Cannot upload" );
  }
                  }

                  @Override
                  public void onFailure(Call<ImageResponse> call, Throwable t) {
                      Log.d("err",""+t.getLocalizedMessage());

                  }
              });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && data !=null && data.getData() !=null)
        {
            filePath = data.getData();

            try
            {
                Bitmap bitmap  = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), filePath);
                bm = bitmap;
                filename = filePath.getPath().substring(filePath.getPath().lastIndexOf("/")+1);
                img.setImageBitmap(bitmap);
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

}
