package de.sevensender.codingchallenge;
/**
 * @Autor :Ensieh Rahbar
 * @Creation time:03-11-2020
 */


import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import de.sevensender.codingchallenge.util.RSSFeedsParser;
import de.sevensender.codingchallenge.util.XkcdReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import de.sevensender.codingchallenge.util.RSSFeedsParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

@SpringBootApplication
public class CodingchallengeApplication {

    public static void main(String[] args) throws IOException, FeedException, ParserConfigurationException, SAXException {
        SpringApplication.run(CodingchallengeApplication.class, args);
      // new RSSFeedsParser();
      // new XkcdReader().XkcdReader(1);

    }


    }

