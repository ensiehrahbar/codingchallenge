package de.sevensender.codingchallenge.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import static de.sevensender.codingchallenge.util.xkcd.*;

public class RSSFeedsParser {
    static final String TITLE = "title";
    static final String PICTURE_URL = "pictureUrl";
    static final String PUB_DATE = "publishingDate";
    public RSSFeedsParser() {
        try {
            String url = "http://feeds.feedburner.com/PoorlyDrawnLines";
            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                System.out.println(feed.getTitle());
                System.out.println("***********************************");
                for (SyndEntry entry : feed.getEntries()) {
                    System.out.println(entry);
                    System.out.println("***********************************");


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }}
        public void parseWebcomic()
        {
            try {
                // Getting the alt of the comic strip, in this case the strip on page 789
                System.out.println(getAlt(789));

                // Getting the image file of the comic strip on page 789
                File sevenAteNine = getImageFile(789);

                // Get the URL of the image on page 789
                System.out.println(getImageURL(789));

                // Get the URL of the latest xkcd comic
                System.out.println(getNewestURL());

                // Get an image file of the newest xkcd comic
                File late = getNewestImageFile();

                // Get the title of the comic on page 789
                System.out.println(getTitle(789));

                // Returns the latest xkcd comic's page number
                System.out.println(getNewestPageNumber());


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
