package de.sevensender.codingchallenge.serviceImpl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class XkcdReader {
    public JsonObject XkcdReader(int id) throws IOException {
        URL url = new URL("https://xkcd.com/" + id + "/info.0.json");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonElement jsonElement = JsonParser.parseReader
                (new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return jsonObject;
    }
}
