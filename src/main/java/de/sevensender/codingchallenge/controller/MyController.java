package de.sevensender.codingchallenge.controller;

import de.sevensender.codingchallenge.model.CustomJson;
import de.sevensender.codingchallenge.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    private static String FEED_PATH = "http://feeds.feedburner.com/PoorlyDrawnLines";
    @Autowired
    private JsonService jsonService;

    @GetMapping("/")
    public List<CustomJson> get20RecentEntries() {

        return jsonService.getLast20Json();
    }
}