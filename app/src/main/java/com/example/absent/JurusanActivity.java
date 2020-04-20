package com.example.absent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JurusanActivity extends AppCompatActivity {
    public static String KEY_ACTIVITY;
    RecyclerView rvjurusan;
    List<Jurusan>jurusans;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    JurusanAdapter adapter;
    ApiInterface apiInterface;
    StatusJurusan statusJurusan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan);
        linearLayoutManager=new LinearLayoutManager(this);
        rvjurusan=(RecyclerView)findViewById(R.id.rv_jur);
        rvjurusan.setLayoutManager(linearLayoutManager);

        Intent intent=getIntent();
        int i=intent.getIntExtra("idnya",1);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<StatusJurusan>call=apiInterface.getJurusan();
        call.enqueue(new Callback<StatusJurusan>() {
            @Override
            public void onResponse(Call<StatusJurusan> call, Response<StatusJurusan> response) {
                statusJurusan=response.body();
                jurusans=statusJurusan.getValues();
                String a = ((Integer)statusJurusan.getStatusnya()).toString();
                adapter=new JurusanAdapter(jurusans,JurusanActivity.this);
                rvjurusan.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<StatusJurusan> call, Throwable t) {

            }
        });


    }


}
