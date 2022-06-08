package com.example.ganjoor;



import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {



    @GET("hafez/faal")
    Call<Fal> getFal();



}
