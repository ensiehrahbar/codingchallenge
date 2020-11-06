package de.sevensender.codingchallenge.service;

import com.rometools.rome.io.FeedException;
import de.sevensender.codingchallenge.model.CustomJson;

import java.io.IOException;
import java.util.List;

public interface JsonService {
    List<CustomJson> getLast20RecordJson() throws IOException, FeedException;
    List<CustomJson> getLast10RecordXkcd() throws IOException;
    List<CustomJson> getLast10RecordRssFeed() throws IOException, FeedException;

}

