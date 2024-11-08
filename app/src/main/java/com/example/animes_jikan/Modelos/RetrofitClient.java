package com.example.animes_jikan.Modelos;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;

public class RetrofitClient {
    private static final String BASE_URL = "https://api.jikan.moe/v4/";
    private static Retrofit retrofit;

    // Configura el OkHttpClient con un timeout
    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)  // Timeout para establecer conexión
                .writeTimeout(30, TimeUnit.SECONDS)    // Timeout para escritura
                .readTimeout(30, TimeUnit.SECONDS)     // Timeout para lectura
                .build();
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())  // Usar el OkHttpClient con timeout configurado
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
