package de.sevensender.app.service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import de.sevensender.app.model.CustomJson;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * Parsing RSS Feed URI, read and retrieve json according to CustomJson Model
 * */
@Component
public class RSSFeedsParser {

    private final String urlFeed;
    /**
     * Class constructor.
     */
    @Autowired
    public RSSFeedsParser(@Value("${urlFeed}") String urlFeed) {
        this.urlFeed = urlFeed;}
    /**
     * @throws IOException  If an input or output
     *                      exception occurred
     * Method to retrieve last 10 json from RSS Feed Site
     */
    public List<CustomJson> getLast10Feeds() throws IOException, FeedException {
        URL url = new URL(urlFeed);
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(url));
        return feed.getEntries().stream().map(this::syndEntry2CustomJson)
                .collect(Collectors.toList());
    }
    /**
     * Receive feed and return  feed json with desire format and according to CustomModel
     * */
    private CustomJson syndEntry2CustomJson(SyndEntry entry) {
        String imageURL = entry.getContents().get(0).getValue();
        imageURL = HtmlParser.parse(imageURL);

        String title = entry.getTitleEx().getValue();
        String link = entry.getLink();
        Date publishedDate = entry.getPublishedDate();
        LocalDate date = publishedDate.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate();

        return new CustomJson(
                title,
                link,
                date,
                (imageURL));
    }
    /**
     * Through content element of RSS Feed Json retrieve image URL
     * */
    private static class HtmlParser {

        public static String parse(String html) {
            Document doc = Jsoup.parse(html);
            Element div = doc.select("div").first();
            Elements childes = div.getElementsByTag("img");
            return childes.attr("src");
        }
    }
}
