package com.example.animes_jikan.Activity;

import static android.content.ContentValues.TAG;
import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animes_jikan.Adapter.EpisodesAdapter;
import com.example.animes_jikan.Modelos.AnimeResponse;
import com.example.animes_jikan.Modelos.Episode;
import com.example.animes_jikan.Modelos.EpisodeResponse;
import com.example.animes_jikan.Modelos.RetrofitClient;
import com.example.animes_jikan.R;
import com.example.animes_jikan.Servicio.JikanService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EpisodesAdapter adapter;
    private int animeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        animeId = getIntent().getIntExtra("anime_id", -1);
        Log.d("MainActivity", "Anime clicked: " + animeId);
        if (animeId == -1) {
            finish();
            return;
        }

        recyclerView = findViewById(R.id.recyclerViewEpisodes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EpisodesAdapter(this);
        recyclerView.setAdapter(adapter);

        loadEpisodes();
    }

    private void loadEpisodes() {

        JikanService jikanService = RetrofitClient.getRetrofitInstance().create(JikanService.class);
        Call<EpisodeResponse> call = jikanService.getAnimeEpisodes(animeId);

        call.enqueue(new Callback<EpisodeResponse>() {
            @Override
            public void onResponse(Call<EpisodeResponse> call, Response<EpisodeResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    List<Episode> episodes = response.body().getData();
                    if (episodes != null && !episodes.isEmpty()) {
                        adapter.setEpisodes(episodes);
                    } else {
                        Toast.makeText(EpisodesActivity.this,
                                "No se encontraron episodios", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e(TAG, "Error en la respuesta: " + response.code());
                    Toast.makeText(EpisodesActivity.this,
                            "Error al cargar los episodios: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EpisodeResponse> call, Throwable t) {
                Log.e(TAG, "Error en la llamada: ", t);
                Toast.makeText(EpisodesActivity.this,
                        "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
