package com.betomorow.codingdojos.exercices.exo1;

import com.betomorow.codingdojos.exercices.MedalId;
import com.betomorow.codingdojos.exercices.Settings;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GamificationHelper {

    private static OkHttpClient httpClient = new OkHttpClient();

    public static void validateMedal(MedalId id) throws Exception {
        validateMedal(id, true);
    }

    public static void validateMedal(MedalId id, boolean isSuccess) throws Exception {
        httpClient.newCall(
            new Request.Builder().get()
                .url(String.format("%s?user=%s&id=%s&success=%s",
                    Settings.POST_URL,
                    URLEncoder.encode(Settings.USERNAME, StandardCharsets.UTF_8.toString()),
                    id.getValue(),
                    isSuccess ? "true" : "false"
                ))
                .build()
        ).execute();
    }

    public static void uploadCode(String code) throws IOException {
        RequestBody formBody = new FormEncodingBuilder()
            .add("user", Settings.USERNAME)
            .add("code", code)
            .build();
        Request r = new Request.Builder().post(formBody).url(Settings.CODE_URL).build();
        httpClient.newCall(r).execute();
    }
}
