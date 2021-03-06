package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResult);
        tvResults.setVisibility(View.INVISIBLE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0,6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;

                if(gender < 5) {
                    sGender = "Female";
                }
                else{
                    sGender= "Male";
                }
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if(nationality == 0) {
                    sNationality = "SA Citizen";
                }
                else{
                    sNationality = "Permanent Resident";
                }
                String text=getString(R.string.dob)+""+dob+getString(R.string.newLine)+
                        getString(R.string.gender)+sGender+getString(R.string.newLine)+
                        getString(R.string.nationality)+ sNationality+getString(R.string.newLine);
                tvResults.setText(text);
                tvResults.setVisibility(View.VISIBLE);

            }
        });
    }
}
