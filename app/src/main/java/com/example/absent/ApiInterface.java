package com.example.absent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("jurusan/all")
    Call<StatusJurusan> getJurusan();
}
