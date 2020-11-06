package de.sevensender.codingchallenge.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.sevensender.codingchallenge.model.CustomJson;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class XkcdReader {
    public List<CustomJson> xkcdParser(int id) throws IOException {
        URL url = new URL("https://xkcd.com/" + id + "/info.0.json");
        List<CustomJson> json = new ArrayList<>();
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonElement jsonElement = JsonParser.parseReader
                (new InputStreamReader((InputStream) request.getContent()));
        LocalDate myDate = LocalDate.of(jsonElement.getAsJsonObject().get("year").getAsInt(),
                jsonElement.getAsJsonObject().get("month").getAsInt(),
                jsonElement.getAsJsonObject().get("day").getAsInt());
        CustomJson xkcdJson = new CustomJson(jsonElement.getAsJsonObject().get("title").getAsString(),
                jsonElement.getAsJsonObject().get("link").getAsString(),
                java.sql.Date.valueOf(myDate),
                jsonElement.getAsJsonObject().get("img").getAsString());

        json.add(xkcdJson);
        return json;
    }

    public Integer lastXkcdNumber(String path) throws IOException {
        URL url = new URL("https://xkcd.com/info.0.json");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonElement jsonElement = JsonParser.parseReader
                (new InputStreamReader((InputStream) request.getContent()));
        int lastNumber = jsonElement.getAsJsonObject().get("num").getAsInt();
        return lastNumber;
    }


}
