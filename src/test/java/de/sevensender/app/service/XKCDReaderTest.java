package de.sevensender.app.service;

import de.sevensender.app.model.CustomJson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class XKCDReaderTest {

    @InjectMocks
    XKCDReader xkcdReader;

    @Test
    void testGetLast10Records() throws IOException {
        List<CustomJson> result = xkcdReader.getLast10Records();
        assertTrue(result.size()>0);
    }

}