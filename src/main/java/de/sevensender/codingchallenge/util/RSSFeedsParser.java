package de.sevensender.codingchallenge.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import de.sevensender.codingchallenge.model.Feed;

public class RSSFeedsParser {
    public List<Feed> parse(String path) throws IOException, FeedException {
        URL url = new URL(path);
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(url));
        List<Feed> feeds = new ArrayList<Feed>();
        for (SyndEntry entry : feed.getEntries()) {
            String imageURL = HtmlParser.parser(entry.getContents().get(0).getValue());
            feeds.add(
                    new Feed(
                            entry.getTitleEx().getValue(),
                            entry.getLink(),
                            entry.getPublishedDate(),
                            (imageURL)));
        }
        return feeds;
    }
}
