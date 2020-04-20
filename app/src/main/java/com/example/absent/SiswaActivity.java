package com.example.absent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiswaActivity extends AppCompatActivity {
    public static String KEY_ACTIVITY;
    RecyclerView rvitemsiswa;
    List<Siswa>siswaList;
    RecyclerView.LayoutManager layoutManager;
    SiswaAdapter adapter;
    ApiIntSiswa apiIntSiswa;
    StatusSiswa statusSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);

        rvitemsiswa=(RecyclerView)findViewById(R.id.activity_siswa);
        layoutManager= new LinearLayoutManager(this);
        rvitemsiswa.setLayoutManager(layoutManager);

        Intent intent=getIntent();
        int i=intent.getIntExtra("idnya",1);
        apiIntSiswa=ApiClient.getApiClient().create(ApiIntSiswa.class);
        Call<StatusSiswa> call=apiIntSiswa.getSiswa(i);
        call.enqueue(new Callback<StatusSiswa>() {
            @Override
            public void onResponse(Call<StatusSiswa> call, Response<StatusSiswa> response) {
                statusSiswa=response.body();
                siswaList=statusSiswa.getValues();
                String a = ((Integer)statusSiswa.getStatusnya()).toString();
                adapter=new SiswaAdapter(siswaList,SiswaActivity.this);
                rvitemsiswa.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<StatusSiswa> call, Throwable t) {

            }
        });

    }
}
