package com.astronout.mymovieapp.api;

import com.astronout.mymovieapp.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("movie/now_playing")
    Call<MoviesResponse> getNowPlayingMovie(@Query("api_key") String apiKey);

}
