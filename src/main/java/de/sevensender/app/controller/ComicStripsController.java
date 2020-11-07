package de.sevensender.app.controller;

import com.rometools.rome.io.FeedException;
import de.sevensender.app.model.CustomJson;
import de.sevensender.app.service.RSSFeedsParser;
import de.sevensender.app.service.XKCDReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Controller class for making rest API
 * */
@RestController
public class ComicStripsController {

    private final RSSFeedsParser rssFeedsParser;
    private final XKCDReader xkcdReader;

    public ComicStripsController(RSSFeedsParser rssFeedsParser,
                                 XKCDReader xkcdReader) {
        this.rssFeedsParser = rssFeedsParser;
        this.xkcdReader = xkcdReader;
    }
    /**
     * Get rest service to retrieves last 20 json from RSS Feed and XKCD .
     */
    @GetMapping("/")
    public List<CustomJson> getComicStrips() throws IOException, FeedException {

        final List<CustomJson> last20Records = new ArrayList<>();
        last20Records.addAll(rssFeedsParser.getLast10Feeds());
        last20Records.addAll(xkcdReader.getLast10Records());

        Comparator<CustomJson> compareByPublishingDate =
                Comparator.comparing(CustomJson::getPublishingDate, Comparator.reverseOrder());
        return last20Records
                .stream()
                .sorted(compareByPublishingDate)
                .collect(Collectors.toList());

    }
}