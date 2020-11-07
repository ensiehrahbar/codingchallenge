package de.sevensender.app.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import de.sevensender.app.model.CustomJson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * class for reading and processing XKCD URI and belong jsons
 * */
@Component
public class XKCDReader {

    private final String urlXKCD;
    /**
     * Class constructor.
     */
    @Autowired
    public XKCDReader(@Value("${urlXKCD}") String urlXKCD) {
        this.urlXKCD = urlXKCD;
    }
    /**
     * Method for retrieve last 10 json from last XKCD URI
     * */
    public List<CustomJson> getLast10Records() throws IOException {
        int xkcdNumberkcd = getLastXkcdNumber();
        final List<CustomJson> xkcdJsons = new ArrayList<>();
        IntStream.range(xkcdNumberkcd - 10, xkcdNumberkcd).forEach(i ->
        {
            CustomJson json;
            try {
                json = xkcdParser(i);
            } catch (IOException e) {
                return;
            }
            xkcdJsons.add(json);
        });
        return xkcdJsons;
    }
    /**
     * Parse specified xkcd uri with passing number as a integer to retrieve json elements
     * */
    private CustomJson xkcdParser(int id) throws IOException {
        URL url = new URL("https://xkcd.com/" + id + "/info.0.json");
        final JsonElement jsonElement = getJsonElement(url);
        return getCustomJson(jsonElement);
    }
    /**
     * Return last number from last XKCD URI by calling specific url(json)
     * */
    private int getLastXkcdNumber() throws IOException {
        URL url = new URL(urlXKCD);
        return getJsonElement(url).getAsJsonObject().get("num").getAsInt();
    }
    /**
     * Connect to url to read jsons and return json elements
     * */
    private JsonElement getJsonElement(URL url) throws IOException {
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonElement jsonElement = JsonParser.parseReader
                (new InputStreamReader((InputStream) request.getContent()));
        request.disconnect();
        return jsonElement;
    }
    /**
     *   Format retrieved json to desire and requested format by code challenge
     * */
    private CustomJson getCustomJson(JsonElement jsonElement) {
        final LocalDate myDate = getLocalDate(jsonElement);
        final String title = jsonElement.getAsJsonObject().get("title").getAsString();
        final String link = jsonElement.getAsJsonObject().get("link").getAsString();
        final String img = jsonElement.getAsJsonObject().get("img").getAsString();

        return new CustomJson(title, link, myDate, img);
    }
    /**
     * Format Published date to YYYY-MM-DD
     * */
    private LocalDate getLocalDate(JsonElement jsonElement) {
        final int year = jsonElement.getAsJsonObject().get("year").getAsInt();
        final int month = jsonElement.getAsJsonObject().get("month").getAsInt();
        final int day = jsonElement.getAsJsonObject().get("day").getAsInt();

        return LocalDate.of(year, month, day);
    }
}
