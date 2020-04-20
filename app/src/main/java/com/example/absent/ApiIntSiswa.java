package com.example.absent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiIntSiswa {
    @GET("/siswa/all/{idKel}")
    Call<StatusSiswa> getSiswa(@Path("idKel")int idKel);

    @GET("/siswa/{siswaId}")
    Call<StatusSiswa>getSatuSiswa(@Path("siswaId")int idSiswanya);
    
}
