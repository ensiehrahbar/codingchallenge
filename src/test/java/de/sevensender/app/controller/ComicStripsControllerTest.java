package de.sevensender.app.controller;

import com.rometools.rome.io.FeedException;
import de.sevensender.app.model.CustomJson;
import de.sevensender.app.service.RSSFeedsParser;
import de.sevensender.app.service.XKCDReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.when;

public class ComicStripsControllerTest {

  @InjectMocks
  ComicStripsController comicStripsController;

  @Mock
  RSSFeedsParser rssFeedsParser;

  @Mock
  XKCDReader xkcdReader;

  List<CustomJson> rssFeeds = new ArrayList<>();
  List<CustomJson> xKCDs = new ArrayList<>();
  final List<CustomJson> the20ComicStrips = new ArrayList<>();

  @BeforeEach
  void Setup() {
    MockitoAnnotations.initMocks(this);
    rssFeeds = getRssFeeds();
    xKCDs = getXKCDs();
    the20ComicStrips.addAll(rssFeeds);
    the20ComicStrips.addAll(xKCDs);
  }

  @Test
  void getComicStrips() throws IOException, FeedException {
    when(rssFeedsParser.getLast10Feeds()).thenReturn(rssFeeds);
    when(xkcdReader.getLast10Records()).thenReturn(xKCDs);
    final List<CustomJson> comicStrips = comicStripsController.getComicStrips();
    Assertions.assertNotNull(comicStrips);
    Assertions.assertEquals(20, comicStrips.size());
    Assertions.assertEquals(getSortedList(the20ComicStrips), comicStrips);
  }

  private List<CustomJson> getSortedList(List<CustomJson> comicStrips) {
    Comparator<CustomJson> compareByPublishingDate =
        Comparator.comparing(CustomJson::getPublishingDate, Comparator.reverseOrder());

    return comicStrips
        .stream()
        .sorted(compareByPublishingDate)
        .collect(Collectors.toList());
  }

  private List<CustomJson> getRssFeeds() {
    List<CustomJson> returnValue = new ArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(i -> {
      CustomJson customJson = new CustomJson("Strip" + i, "www.test.de/" + i + ".html",
          LocalDate.now().plusDays(i),
          "www.test.de/test" + i + ".png");
      returnValue.add(customJson);
    });

    IntStream.rangeClosed(6, 10).forEach(i -> {
      CustomJson customJson = new CustomJson("Strip" + i, "www.test.de/" + i + ".html",
          LocalDate.now().minusDays(i),
          "www.test.de/test" + i + ".png");
      returnValue.add(customJson);
    });
    return returnValue;
  }

  private List<CustomJson> getXKCDs() {
    List<CustomJson> returnValue = new ArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(i -> {
      CustomJson customJson = new CustomJson("comic" + i, "www.comic.de/" + i + ".html",
          LocalDate.now().plusDays(i * 2),
          "www.comic.de/comic" + i + ".jpg");
      returnValue.add(customJson);
    });

    IntStream.rangeClosed(6, 10).forEach(i -> {
      CustomJson customJson = new CustomJson("Strip" + i, "www.comic.de/" + i + ".html",
          LocalDate.now().minusDays(i * 2),
          "www.comic.de/comic" + i + ".jpg");
      returnValue.add(customJson);
    });
    return returnValue;
  }


}
