package de.sevensender.codingchallenge.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


public class RSSFeedsParser {
    static final String TITLE = "title";
    static final String PICTURE_URL = "pictureUrl";
    static final String PUB_DATE = "publishingDate";

    public RSSFeedsParser() throws IOException, FeedException {

   /*     RestTemplate restTemplate = new RestTemplate();
        SyndFeed syndFeed = restTemplate.execute(feedUrl, HttpMethod.GET, null, response -> {
            SyndFeedInput input = new SyndFeedInput();
            try {
                return input.build(new XmlReader(response.getBody()));
            } catch (FeedException e) {
                throw new IOException("Could not parse response", e);
            }
        });*/


        URL url = new URL("http://feeds.feedburner.com/PoorlyDrawnLines");
        SyndFeed feed;
        feed = new SyndFeedInput().build(new XmlReader(url));

        for (SyndEntry entry : feed.getEntries()) {
            System.out.println(entry);
            System.out.println("======================================");
        }
        System.out.println(feed.getTitle());

    }
}