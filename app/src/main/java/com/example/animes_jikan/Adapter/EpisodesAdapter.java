package com.example.animes_jikan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animes_jikan.Modelos.Episode;
import com.example.animes_jikan.R;

import java.util.ArrayList;
import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder> {
    private List<Episode> episodes;
    private Context context;

    public EpisodesAdapter(Context context) {
        this.context = context;
        this.episodes = new ArrayList<>();
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
        notifyDataSetChanged();
    }

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_episode, parent, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EpisodeViewHolder holder, int position) {
        Episode episode = episodes.get(position);
        holder.title.setText(episode.getTitle());
        holder.aired.setText("Emisión: " + episode.getAired());
        holder.score.setText("Puntuación: " + episode.getScore());
    }

    @Override
    public int getItemCount() {
        return episodes != null ? episodes.size() : 0;
    }

    static class EpisodeViewHolder extends RecyclerView.ViewHolder {
        TextView title, aired, score;

        public EpisodeViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.episodeTitle);
            aired = itemView.findViewById(R.id.episodeAired);
            score = itemView.findViewById(R.id.episodeScore);
        }
    }
}
