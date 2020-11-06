package de.sevensender.codingchallenge.controller;

import com.rometools.rome.io.FeedException;
import de.sevensender.codingchallenge.model.CustomJson;
import de.sevensender.codingchallenge.util.RSSFeedsParser;
import de.sevensender.codingchallenge.util.XKCDReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyController {

  @Autowired
  RSSFeedsParser rssFeedsParser;
  @Autowired
  XKCDReader xkcdReader;

  @GetMapping("/")
  public List<CustomJson> getJson() throws IOException, FeedException {

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