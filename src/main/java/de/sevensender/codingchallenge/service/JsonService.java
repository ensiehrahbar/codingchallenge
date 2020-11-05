package de.sevensender.codingchallenge.service;

import de.sevensender.codingchallenge.model.CustomJson;

import java.util.List;

public interface JsonService {
    List<CustomJson> getLast20Json();
}

