package com.blogspot.yourfavoritekaisar.footballmvp.model.network;

import com.blogspot.yourfavoritekaisar.footballmvp.model.FootBall.FootballResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/search_all_teams.php")
    Call<FootballResponse> getFootballList(
            @Query("l") String l
    );

    @GET("/api/v1/json/1/lookupteam.php")
    Call<FootballResponse> getDetailResponse(
            @Query("id") int id
    );

}
