package fragements;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.onlinehotelreservationsytem.R;
import com.example.onlinehotelreservationsytem.ReservationActivity;

public class ReservationFragement extends Fragment {

    private static final String BASE_URL = "http://10.0.2.2:3000/";
    private Spinner spin;
    private EditText txtfn, txtmn, txtln, phone, txtemail, txtamt, txtenail;
    private Button rebtn;
    DatePicker txtdate;
    private String date;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_reservation, container, false);
        txtfn=view.findViewById(R.id.txtfn);
        spin=view.findViewById(R.id.spin);
        ArrayAdapter<String> myadpater = new ArrayAdapter<String>(ReservationFragement.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.roomtype));
        return view;

    }
}
