package com.example.absent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilSiswa extends AppCompatActivity {
    TextView nis,nama,alamat,jenkel,ttl;
    Button detail,absen;
    ApiIntSiswa apiIntSiswa;
    int ab;
    StatusSiswa statusSiswa;
    Siswa siswa;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_siswa);
        nis=(TextView)findViewById(R.id.nis2);
        nama=(TextView)findViewById(R.id.nama_siswa2);
        alamat=(TextView)findViewById(R.id.alamat);
        jenkel=(TextView)findViewById(R.id.jenkel);
        ttl=(TextView)findViewById(R.id.ttl);
        detail=(Button)findViewById(R.id.btn_detail);
        absen=(Button)findViewById(R.id.btn_absen);
        Intent intent=getIntent();
        ab=intent.getIntExtra("idsis",1);
        apiIntSiswa=ApiClient.getApiClient().create(ApiIntSiswa.class);
        Call<StatusSiswa>call=apiIntSiswa.getSatuSiswa(ab);
        call.enqueue(new Callback<StatusSiswa>() {
            @Override
            public void onResponse(Call<StatusSiswa> call, Response<StatusSiswa> response) {
                statusSiswa=response.body();
                siswa=statusSiswa.getValues().get(0);
                nis.setText(siswa.getNis());
                nama.setText(siswa.getNama());
                alamat.setText(siswa.getAlamat());
                jenkel.setText(siswa.getJen_kel());
                ttl.setText(siswa.getTtl());
            }

            @Override
            public void onFailure(Call<StatusSiswa> call, Throwable t) {

            }
        });


    }
}
