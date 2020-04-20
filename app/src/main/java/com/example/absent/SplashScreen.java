package com.example.absent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    private ApiInterface apiInterface;
    private StatusJurusan statusJurusan;
    private List<Jurusan> jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new AmbilData().execute();

    }

        private class AmbilData extends AsyncTask<Void,Void,Void>{


            @Override
            protected Void doInBackground(Void... voids) {

                apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
                Call<StatusJurusan>call=apiInterface.getJurusan();
                call.enqueue(new Callback<StatusJurusan>() {
                    @Override
                    public void onResponse(Call<StatusJurusan> call, Response<StatusJurusan> response) {
                        statusJurusan=response.body();
                        jurusan=statusJurusan.getValues();
                        Intent intent=new Intent(SplashScreen.this,JurusanActivity.class);
                        intent.putExtra("datanya",(Serializable)jurusan);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<StatusJurusan> call, Throwable t) {

                    }
                });
                return null;

            }
        }
}