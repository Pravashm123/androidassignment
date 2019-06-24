package com.example.onlinehotelreservationsytem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.com.api.onlinehotelreservationsystem.APIConnection;
import com.com.api.onlinehotelreservationsystem.Userapi;
import com.model.onlinehotelreservationsytem.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignupActivity extends AppCompatActivity {

    private static final String BASE_URL="http://10.0.2.2:3000/";
    Retrofit  retrofit;
    Userapi userApi;
    private TextView usertype;
    private EditText fn,mn,ls,address,email,contact,username,password;
    Button btnlogin,btnregister;
    private Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        spin = findViewById(R.id.spin);
        usertype=findViewById(R.id.usertype);
        fn=findViewById(R.id.fn);
        mn=findViewById(R.id.mn);
        ls=findViewById(R.id.ls);
        address=findViewById(R.id.address);
        contact=findViewById(R.id.contact);
        email=findViewById(R.id.email);
        username=findViewById(R.id.etUsername);
        password=findViewById(R.id.etPassword);
        btnregister=findViewById(R.id.btnRegister);
        btnlogin=findViewById(R.id.login1);


        ArrayAdapter<String> myadpater=new ArrayAdapter<String>(SignupActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.types));

        myadpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(myadpater);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userapi user= APIConnection.getRetrofit();
             boolean admin=false;
             // String room=  spin.getSelectedItem().toString();
             //   int index=spin.get
                int index =spin.getSelectedItemPosition();
                if (index ==1)
                {
                    admin=true;

                }

        Toast.makeText(SignupActivity.this, "Success"+spin.getSelectedItemPosition(), Toast.LENGTH_LONG).show();
                Call <ResponseBody> call=user.signup(
new User(admin,fn.getText().toString(),mn.getText().toString(),ls.getText().toString(),address.getText().toString(),contact.getText().toString(),email.getText().toString(),username.getText().toString(),password.getText().toString()));
  call.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
          if (response.isSuccessful())
          {
              Toast.makeText(SignupActivity.this, "Success", Toast.LENGTH_LONG).show();
          }

          else {
              Toast.makeText(SignupActivity.this,"failed",Toast.LENGTH_LONG).show();
          }
      }

      @Override
      public void onFailure(Call<ResponseBody> call, Throwable t) {

      }
  });



            }
        });



    }
}
