package com.example.animes_jikan.Adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.animes_jikan.Modelos.Anime;
import com.example.animes_jikan.R;

import java.util.ArrayList;
import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    private List<Anime> animeList;
    private Context context;

    public AnimeAdapter(Context context) {
        this.context = context;
        this.animeList = new ArrayList<>();
    }

    public void setAnimes(List<Anime> animes) {
        this.animeList = animes;
        notifyDataSetChanged();
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder holder, int position) {
        Anime anime = animeList.get(position);

        // Verificar si los datos no son null antes de asignarlos
        holder.title.setText(anime.getTitle() != null ? anime.getTitle() : "Sin título");
        holder.startDate.setText("Emisión: " + (anime.getAired().getFrom()));
        holder.endDate.setText("Finalización: " + (anime.getAired().getTo()));
        holder.episodes.setText("Episodios: " + (anime.getEpisodes()));

        // Usar Glide para cargar la imagen
        if (anime.getImages().getJpg().getImageUrl() != null && !anime.getImages().getJpg().getImageUrl().isEmpty()) {
            Glide.with(context)
                    .load(anime.getImages().getJpg().getImageUrl())
                    .placeholder(R.drawable.ic_launcher_background) // Asegúrate de tener una imagen placeholder
                    .error(R.drawable.ic_launcher_background) // Asegúrate de tener una imagen de error
                    .into(holder.imageView);

            Log.d(TAG, "URL IMAGEN: " + anime.getImages().getJpg().getImageUrl());
        } else {
            holder.imageView.setImageResource(R.drawable.ic_launcher_background); // Imagen por defecto
        }
    }

    @Override
    public int getItemCount() {
        return animeList != null ? animeList.size() : 0;
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        TextView title, startDate, endDate, episodes;
        ImageView imageView;

        public AnimeViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            startDate = itemView.findViewById(R.id.startDate);
            endDate = itemView.findViewById(R.id.endDate);
            episodes = itemView.findViewById(R.id.episodes);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}