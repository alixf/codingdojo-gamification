package com.betomorow.codingdojos.exercices.exo1;

import com.betomorow.codingdojos.exercices.Settings;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GamificationHelper {

    private static OkHttpClient httpClient = new OkHttpClient();

    public static void validateMedal(String id) throws Exception {
        validateMedal(id, true);
    }

    public static void validateMedal(String id, boolean isSuccess) throws Exception {
        httpClient.newCall(
            new Request.Builder().get()
                .url(String.format("http://localhost:9090/post?user=%s&id=%s&success=%s",
                    URLEncoder.encode(Settings.USERNAME, StandardCharsets.UTF_8.toString()),
                    id,
                    isSuccess ? "true" : "false"
                ))
                .build()
        ).execute();
    }

    public static void uploadCode(String id, String code) {

    }
}
