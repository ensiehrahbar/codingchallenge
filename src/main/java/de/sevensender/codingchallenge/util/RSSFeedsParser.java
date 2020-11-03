package de.sevensender.codingchallenge.util;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;

import javax.sql.RowSetInternal;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.spi.XmlReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

public class RSSFeedsParser {
    static final String TITLE = "title";
    static final String PICTURE_URL = "pictureUrl";
    static final String PUB_DATE = "publishingDate";
    final URL url;
    public RSSFeedsParser(String feedUrl) throws MalformedURLException {
        try {
            this.url = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    URL feedSource = new URL("https://www.feed-reader.net/index.php");
    SyndFeedInput input = new SyndFeedInput();
    SyndFeed feed = input.build(new XmlReader(feedSource) {
        @Override
        public void readData(RowSetInternal caller) throws SQLException {

        }

        @Override
        public void readXML(WebRowSet caller, Reader reader) throws SQLException {

        }
    });
}
