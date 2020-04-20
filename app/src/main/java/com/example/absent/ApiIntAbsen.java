package com.example.absent;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiIntAbsen {
    @GET("/absen")
    Call<StatusAbsen> getAbsen();

    @POST("exec")
    Call<StatusAbsen> postUpload(
            @Field("id_sis") String idsis,
            @Field("id_pengab") String idpengabsen,
            @Field("ket") String keterangan,
            @Field("tgl") String Date

            );
}
