package com.example.testbg.Network;

import com.example.testbg.models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("everything")
    Call<SearchResponse> getNews(
            @Query("domains") String domains,
            @Query("apiKey") String apiKey,
            @Query("pageSize") int pageSize
    );
}

