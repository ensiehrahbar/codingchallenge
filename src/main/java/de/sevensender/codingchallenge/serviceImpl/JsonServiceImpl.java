package de.sevensender.codingchallenge.serviceImpl;

import de.sevensender.codingchallenge.model.CustomJson;
import de.sevensender.codingchallenge.service.JsonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonServiceImpl implements JsonService {
    public List<CustomJson> getLast20Json() {

        List<CustomJson> customJsonList = new ArrayList<CustomJson>();
       // customJsonList.add(new CustomJson());
        return customJsonList;
    }
}
