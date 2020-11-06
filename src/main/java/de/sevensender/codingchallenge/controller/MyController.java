package de.sevensender.codingchallenge.controller;

import com.rometools.rome.io.FeedException;
import de.sevensender.codingchallenge.model.CustomJson;
import de.sevensender.codingchallenge.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.LastModified;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyController {
 // private static String FEED_PATH = "http://feeds.feedburner.com/PoorlyDrawnLines";
 @Autowired
 private JsonService jsonService;

 @GetMapping("/")
 public  List<CustomJson> getJson() {
  //first name comparator
  Comparator<CustomJson> compareByPublishingDate = Comparator.comparing( CustomJson::getPublishingDate,Comparator.reverseOrder());

  try {
   return jsonService.getLast20RecordJson().stream().sorted(compareByPublishingDate).collect(Collectors.toList());
  } catch (IOException e) {
   e.printStackTrace();
  } catch (FeedException e) {
   e.printStackTrace();
  }
  return null;
 }
}