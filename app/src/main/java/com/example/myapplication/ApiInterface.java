package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/top_rated?api_key=02514a833edd3813d9165daab702f5b8")
    Call<MovieModel> getTopRated();

    @GET("movie/popular?api_key=02514a833edd3813d9165daab702f5b8")
    Call<MovieModel> getPopular();

    @GET("movie/upcoming?api_key=02514a833edd3813d9165daab702f5b8")
    Call<MovieModel> getUpcoming();

    @GET("3/movie/{id}?api_key=02514a833edd3813d9165daab702f5b8")
    Call<MovieParsing> getData(@Path("id") int idint);

    @GET("movie/top_rated")
    Call<MovieModel> getLoadTopRated(@Query("api_key") String api_key,@Query("page") int pg);

    @GET("movie/upcoming")
    Call<MovieModel> getLoadUpcoming(@Query("api_key") String api_key,@Query("page") int pg);

    @GET("movie/popular")
    Call<MovieModel> getLoadPopular(@Query("api_key") String api_key,@Query("page") int pg);

}
