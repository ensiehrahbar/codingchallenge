package de.sevensender.app.service;

import com.rometools.rome.io.FeedException;
import de.sevensender.app.model.CustomJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
class RSSFeedsParserTest {

    @InjectMocks
    RSSFeedsParser rssFeedsParser;

    @Test
    void  testGetLast10Feeds() throws IOException, FeedException {
        List<CustomJson> result = rssFeedsParser.getLast10Feeds();

        Assertions.assertTrue(result.size()>0);
    }

}