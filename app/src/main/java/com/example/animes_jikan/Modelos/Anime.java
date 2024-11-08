package com.example.animes_jikan.Modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Anime {
    @SerializedName("mal_id")
    private int malId;

    @SerializedName("url")
    private String url;

    @SerializedName("images")
    private Images images;

    @SerializedName("titles")
    private List<Title> titles;

    @SerializedName("title")
    private String title;

    @SerializedName("title_english")
    private String titleEnglish;

    @SerializedName("title_japanese")
    private String titleJapanese;

    @SerializedName("episodes")
    private int episodes;

    @SerializedName("status")
    private String status;

    @SerializedName("aired")
    private Aired aired;

    @SerializedName("score")
    private double score;

    @SerializedName("synopsis")
    private String synopsis;

    // Nested classes for complex objects
    public static class Images {
        @SerializedName("jpg")
        private ImageUrls jpg;

        public ImageUrls getJpg() { return jpg; }
    }

    public static class ImageUrls {
        @SerializedName("image_url")
        private String imageUrl;

        @SerializedName("large_image_url")
        private String largeImageUrl;

        public String getImageUrl() { return imageUrl; }
        public String getLargeImageUrl() { return largeImageUrl; }
    }

    public static class Title {
        @SerializedName("type")
        private String type;

        @SerializedName("title")
        private String title;

        public String getType() { return type; }
        public String getTitle() { return title; }
    }

    public static class Aired {
        @SerializedName("from")
        private String from;

        @SerializedName("to")
        private String to;

        public String getFrom() { return from; }
        public String getTo() { return to; }
    }

    // Getters
    public int getMalId() { return malId; }
    public String getUrl() { return url; }
    public Images getImages() { return images; }
    public List<Title> getTitles() { return titles; }
    public String getTitle() { return title; }
    public String getTitleEnglish() { return titleEnglish; }
    public String getTitleJapanese() { return titleJapanese; }
    public int getEpisodes() { return episodes; }
    public String getStatus() { return status; }
    public Aired getAired() { return aired; }
    public double getScore() { return score; }
    public String getSynopsis() { return synopsis; }
}