package com.example.animes_jikan;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animes_jikan.Adapter.AnimeAdapter;
import com.example.animes_jikan.Modelos.Anime;
import com.example.animes_jikan.Modelos.AnimeResponse;
import com.example.animes_jikan.Modelos.RetrofitClient;
import com.example.animes_jikan.Servicio.JikanService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimeAdapter animeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener la lista de animes
        JikanService apiService = RetrofitClient.getRetrofitInstance().create(JikanService.class);
        Call<AnimeResponse> call = apiService.getAnimeList(1, 5);  // Obtener 5 animes de la API

        call.enqueue(new Callback<AnimeResponse>() {
            @Override
            public void onResponse(Call<AnimeResponse> call, Response<AnimeResponse> response) {
                if (response.isSuccessful()) {
                    List<Anime> animeList = response.body().getData();
                    animeAdapter = new AnimeAdapter(MainActivity.this);

                    recyclerView.setAdapter(animeAdapter);

                    animeAdapter.setAnimes(animeList);
                } else {
                    Toast.makeText(MainActivity.this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AnimeResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fallo en la conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}