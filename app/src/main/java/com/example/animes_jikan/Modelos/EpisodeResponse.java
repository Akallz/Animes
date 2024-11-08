package com.example.animes_jikan.Modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EpisodeResponse {
    @SerializedName("data")
    private List<Episode> data;

    @SerializedName("pagination")
    private Pagination pagination;

    public List<Episode> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
