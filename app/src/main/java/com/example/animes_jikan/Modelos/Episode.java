package com.example.animes_jikan.Modelos;

import com.google.gson.annotations.SerializedName;

public class Episode {
    @SerializedName("mal_id")
    private int malId;

    @SerializedName("title")
    private String title;

    @SerializedName("aired")
    private String aired;

    @SerializedName("score")
    private double score;

    // Getters
    public int getMalId() { return malId; }
    public String getTitle() { return title; }
    public String getAired() { return aired; }
    public double getScore() { return score; }
}
