package com.example.absent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterfaceLogIn {
    @GET("/pengabsen/pass/email")
    Call<List<Password>>getPass(@Query("email")String email);
    @POST("/pengabsen/sigin")
    @FormUrlEncoded
    Call<Token>getToken(@Field("email")String email,
                        @Field("password")String password);
}
