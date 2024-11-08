package com.example.animes_jikan.Servicio;

import com.example.animes_jikan.Modelos.AnimeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JikanService {
    @GET("anime")
    Call<AnimeResponse> getAnimeList(@Query("page") int page, @Query("limit") int limit);
}
