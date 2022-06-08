package com.example.ganjoor;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {



    @GET("hafez/faal")
    Call<Fal> getFal();

    @GET("poets")
    Call<List<Poet>> getPoet();


}
