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

public class KelasActivity extends AppCompatActivity {
    public static String KEY_ACTIVTY;
    RecyclerView rvkelas;
    List<Kelas> kelasList;
    RecyclerView.LayoutManager layoutManager;
    KelasAdapter kelasAdapter;
    ApiIntKelas apiIntKelas;
    StatusKelas statusKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas);

        rvkelas=(RecyclerView)findViewById(R.id.activity_kelas);
        layoutManager=new LinearLayoutManager(this);
        rvkelas.setLayoutManager(layoutManager);

        Intent intent=getIntent();
        int i=intent.getIntExtra("idnya",1);
        apiIntKelas=ApiClient.getApiClient().create(ApiIntKelas.class);
        Call<StatusKelas>call=apiIntKelas.getKelas(i);
        call.enqueue(new Callback<StatusKelas>() {
            @Override
            public void onResponse(Call<StatusKelas> call, Response<StatusKelas> response) {
                statusKelas=response.body();
                kelasList=statusKelas.getValues();
                String a = ((Integer)statusKelas.getStatusnya()).toString();
                kelasAdapter=new KelasAdapter(kelasList,KelasActivity.this);
                rvkelas.setAdapter(kelasAdapter);
            }

            @Override
            public void onFailure(Call<StatusKelas> call, Throwable t) {

            }
        });



    }
}
