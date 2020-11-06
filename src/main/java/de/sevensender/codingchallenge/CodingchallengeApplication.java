package de.sevensender.codingchallenge;
/**
 * @Autor :Ensieh Rahbar
 * @Creation time:03-11-2020
 */

import com.rometools.rome.io.FeedException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

@SpringBootApplication
public class CodingchallengeApplication {
    public static void main(String[] args) throws IOException, FeedException, ParserConfigurationException, SAXException {
        SpringApplication.run(CodingchallengeApplication.class, args);
    }
}

