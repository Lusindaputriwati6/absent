package com.example.absent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiIntKelas {
    @GET("kelas/all/{idJur}")
    Call<StatusKelas> getKelas(@Path("idJur")int idJur);
}
