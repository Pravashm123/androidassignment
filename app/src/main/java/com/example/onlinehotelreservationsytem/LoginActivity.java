package com.example.onlinehotelreservationsytem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.com.api.onlinehotelreservationsystem.APIConnection;
import com.com.api.onlinehotelreservationsystem.Userapi;
import com.model.onlinehotelreservationsytem.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
   private Button btnregister,btnlogin;
   private EditText untxt,passtxt;
    Retrofit retrofit;
    Userapi userApi;
    private static final String BASE_URL="http://10.0.2.2:3000/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        untxt=findViewById(R.id.etUsername);
        passtxt=findViewById(R.id.etPassword);
        btnlogin=findViewById(R.id.btnLogin);
        btnregister=findViewById(R.id.register1);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }

        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userapi user = APIConnection.getRetrofit();
                Call<User> call=user.login(new User(untxt.getText().toString(),passtxt.getText().toString()));
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                     if (response.isSuccessful()) {
                         User u  = (User) response.body();
                         if (u.isAdmin())
                         {
                             //admin dashboard
//                      Toast.makeText(LoginActivity.this, "admin", Toast.LENGTH_LONG).show();
//                                                      Intent i = new Intent(LoginActivity.this, New_Dash.class);
//                         startActivity(i);

                         }

                         else
                         {
                             Toast.makeText(LoginActivity.this, "normal", Toast.LENGTH_LONG).show();
                             //normal dashboard
                             Intent i = new Intent(LoginActivity.this, New_Dash.class);
                             startActivity(i);
                         }



                     }



                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });

    }
}
