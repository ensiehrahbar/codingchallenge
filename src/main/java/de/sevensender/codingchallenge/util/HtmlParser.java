package de.sevensender.codingchallenge.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

    public static String parser(String html) {
        Document doc = Jsoup.parse(html);
        Element div = doc.select("div").first();
        Elements childes = (Elements) div.getElementsByTag("img");
        String imageURL = childes.attr("src");
        return imageURL;
    }
}
