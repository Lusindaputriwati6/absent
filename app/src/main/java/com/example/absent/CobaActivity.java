package com.example.absent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CobaActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        txt=(TextView)findViewById(R.id.txt_password);
        Intent intent=getIntent();
        String pass=intent.getStringExtra("pesan");
        txt.setText(pass);

    }
}
