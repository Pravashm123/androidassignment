package com.example.onlinehotelreservationsytem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.com.api.onlinehotelreservationsystem.APIConnection;
import com.com.api.onlinehotelreservationsystem.Reservationapi;
import com.model.onlinehotelreservationsytem.Reservation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://10.0.2.2:3000/";
    private Spinner spin;
    private EditText txtfn, txtmn, txtln, phone, txtemail, txtamt, txtenail;
    private Button rebtn;
    DatePicker txtdate;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        txtfn = findViewById(R.id.txtfn);
        txtmn = findViewById(R.id.txtmn);
        txtln = findViewById(R.id.txtln);
        phone = findViewById(R.id.txtphone);
        txtemail = findViewById(R.id.txtemail);
        txtdate = findViewById(R.id.txtdate);
        txtamt = findViewById(R.id.txtamt);
        spin = findViewById(R.id.roomspin);
        rebtn = findViewById(R.id.rebtn);
        ArrayAdapter<String> myadpater = new ArrayAdapter<String>(ReservationActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.roomtype));

        txtdate.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int month, int day) {
                date = year + "/" + month + "/" + day;
            }
        });
        myadpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(myadpater);
        rebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reservationapi reservationapi = APIConnection.getReservation();
                String room = spin.getSelectedItem().toString();

                Call<ResponseBody> call = reservationapi.reserve(new Reservation(txtfn.getText().toString(), txtmn.getText().toString(), txtln.getText().toString(), room, phone.getText().toString(),
                        date, txtamt.getText().toString(), txtemail.getText().toString()));
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {

                            Toast.makeText(ReservationActivity.this, "Success", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ReservationActivity.this, "failed", Toast.LENGTH_LONG).show();
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
