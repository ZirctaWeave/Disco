package me.zircta.disco.utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class APIUtils {
    public static String auth = "TOKEN!";

    public static void sendDiscordMessage(String message) {
        try {
            HttpURLConnection connection = getHttpURLConnection();

            String jsonPayload = "{\"mobile_network_type\":\"unknown\",\"content\":\"" + message + "\",\"nonce\":null,\"tts\":false,\"flags\":0}";

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(jsonPayload.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = connection.getResponseCode();

            System.out.println("Response Code: " + responseCode);

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NotNull
    private static HttpURLConnection getHttpURLConnection() throws IOException {
        String apiUrl = "https://discord.com/api/v9/channels/1081741605360377998/messages";

        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");

        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", auth);

        connection.setDoOutput(true);
        return connection;
    }
}
