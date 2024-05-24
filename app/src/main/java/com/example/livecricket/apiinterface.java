package com.example.livecricket;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiinterface {

    String BASE_URL="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<news> getnews(

            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey


    );
    @GET("top-headlines")
    Call<news> getcategorynews(

            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey,
            @Query("category") String category


    );
}
