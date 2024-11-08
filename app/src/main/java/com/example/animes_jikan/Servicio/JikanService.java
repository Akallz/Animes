package com.example.animes_jikan.Servicio;

import com.example.animes_jikan.Modelos.AnimeResponse;
import com.example.animes_jikan.Modelos.Episode;
import com.example.animes_jikan.Modelos.EpisodeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JikanService {
    @GET("anime")
    Call<AnimeResponse> getAnimeList(@Query("page") int page, @Query("limit") int limit);

    @GET("anime/{id}/episodes")
    Call<EpisodeResponse> getAnimeEpisodes(@Path("id") int animeId);
}
