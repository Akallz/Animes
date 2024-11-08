package com.example.animes_jikan.Modelos;

import com.google.gson.annotations.SerializedName;

public class Pagination {
    @SerializedName("last_visible_page")
    private int lastVisiblePage;

    @SerializedName("has_next_page")
    private boolean hasNextPage;

    @SerializedName("items")
    private Items items;

    public static class Items {
        @SerializedName("count")
        private int count;

        @SerializedName("total")
        private int total;

        @SerializedName("per_page")
        private int perPage;

        public int getCount() { return count; }
        public int getTotal() { return total; }
        public int getPerPage() { return perPage; }
    }

    // Getters
    public int getLastVisiblePage() { return lastVisiblePage; }
    public boolean isHasNextPage() { return hasNextPage; }
    public Items getItems() { return items; }
}