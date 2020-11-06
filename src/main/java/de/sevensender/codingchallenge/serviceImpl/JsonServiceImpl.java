package de.sevensender.codingchallenge.serviceImpl;

import com.rometools.rome.io.FeedException;
import de.sevensender.codingchallenge.model.CustomJson;
import de.sevensender.codingchallenge.service.JsonService;
import de.sevensender.codingchallenge.util.RSSFeedsParser;
import de.sevensender.codingchallenge.util.XkcdReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonServiceImpl implements JsonService {
    static final String URL_RSSFEED = "http://feeds.feedburner.com/PoorlyDrawnLines";
    static final String URL_XKCDNUMBEROFFILE = "https://xkcd.com/info.0.json";
    @Autowired
    RSSFeedsParser rssFeedsParser;
    @Autowired
    XkcdReader xkcdReader;
    List<CustomJson> customJsonList = new ArrayList<CustomJson>();

    @Override
    public List<CustomJson> getLast20RecordJson() throws IOException, FeedException {
        customJsonList = getLast10RecordRssFeed();
        customJsonList = getLast10RecordXkcd();
        return customJsonList;
    }

    @Override
    public List<CustomJson> getLast10RecordRssFeed() throws IOException, FeedException {

        List<CustomJson> jsonFeed = rssFeedsParser.parse(URL_RSSFEED);
        for (int i = 0; i < 10; i++) {
            CustomJson customJson = new CustomJson(jsonFeed.get(i).getTitle(),
                    jsonFeed.get(i).getBrowserViewURL(),
                    jsonFeed.get(i).getPublishingDate(),
                    jsonFeed.get(i).getImageURL());
            customJsonList.add(customJson);
        }
        return customJsonList;
    }

    @Override
    public List<CustomJson> getLast10RecordXkcd() throws IOException {
        int xkcdNumberkcd = xkcdReader.lastXkcdNumber(URL_XKCDNUMBEROFFILE);
        List<CustomJson> jsonXkcd =new ArrayList<>();
                //xkcdReader.xkcdParser(xkcdNumberkcd);
        for (int i = xkcdNumberkcd; i > xkcdNumberkcd - 10; i--) {
            jsonXkcd=xkcdReader.xkcdParser(i);
            CustomJson customJson = new CustomJson(jsonXkcd.get(0).getTitle(),
                    jsonXkcd.get(0).getBrowserViewURL(),
                    jsonXkcd.get(0).getPublishingDate(),
                   jsonXkcd.get(0).getImageURL());
            customJsonList.add(customJson);
        }


        return customJsonList;
    }
}
